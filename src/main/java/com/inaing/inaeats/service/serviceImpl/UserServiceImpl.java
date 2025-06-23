package com.inaing.inaeats.service.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inaing.inaeats.dto.otp.OtpCreationRequestDto;
import com.inaing.inaeats.dto.otp.OtpCreationResponseDto;
import com.inaing.inaeats.dto.otp.OtpValidationDto;
import com.inaing.inaeats.dto.user.BasicUserDetailsWithTokenDto;
import com.inaing.inaeats.dto.user.RegisterUserRequestDto;
import com.inaing.inaeats.dto.user.UserRequestDto;
import com.inaing.inaeats.entity.User;
import com.inaing.inaeats.entity.enums.UserType;
import com.inaing.inaeats.exception.exceptions.RestStandardException;
import com.inaing.inaeats.mapper.UserMapper;
import com.inaing.inaeats.repository.UserRepository;
import com.inaing.inaeats.security.jwtFilter.JwtService;
import com.inaing.inaeats.service.UserService;
import com.inaing.inaeats.utils.otp.StringGenerator;
import com.inaing.inaeats.utils.otp.impl.NumericOtpGenerator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final StringGenerator numericOtpGenerator = new NumericOtpGenerator(6);
    private final UserMapper userMapper;

    @Override
    public BasicUserDetailsWithTokenDto register(RegisterUserRequestDto registerUserRequestDto) {
        User user = userRepository.findByPhone(registerUserRequestDto.getPhone())
                .orElseThrow(() -> new UsernameNotFoundException("User with this phone number doesn't exist"));
        user.setPhone(registerUserRequestDto.getPhone());
        user.setDob(registerUserRequestDto.getDob());
        user.setEmail(registerUserRequestDto.getEmail());
        user.setFullname(registerUserRequestDto.getFullname());
        user.setGender(registerUserRequestDto.getGender());
        user.setHasRegistered(true);
        user.setAge(Period.between(registerUserRequestDto.getDob().toLocalDate(), LocalDate.now()).getYears());
        user.setUserType(UserType.USER);
        user = userRepository.save(user);

        BasicUserDetailsWithTokenDto basicUserDetailsWithTokenDto = userMapper.tobaBasicUserDetailsWithTokenDto(user);
        basicUserDetailsWithTokenDto.setToken(JwtService.generateToken(user));
        return basicUserDetailsWithTokenDto;
    }

    @Override
    public OtpCreationResponseDto sendOtp(OtpCreationRequestDto otpCreationRequestDto) {
        User user = userRepository.findByPhone(otpCreationRequestDto.getPhone()).orElse(new User());
        if (!user.getHasRegistered()) {
            user.setPhone(otpCreationRequestDto.getPhone());
            user.setHasRegistered(false);
        }
        String otp = numericOtpGenerator.generate();
        log.info("Otp has been sent to" + otpCreationRequestDto.getPhone());
        System.out.println("otp is" + otp);
        LocalDateTime expiryTime = otpCreationRequestDto.getRequestTime().plusMinutes(2);
        OtpCreationResponseDto otpCreationResponseDto = new OtpCreationResponseDto("Otp has been sent successfully",
                expiryTime);
        user.setOtp(otp);
        user.setOtpExpireTime(expiryTime);
        userRepository.save(user);
        return otpCreationResponseDto;
    }

    @Override
    public void validateOtp(OtpValidationDto otpValidationDto) {
        User user = userRepository.findByPhone(otpValidationDto.getPhone())
                .orElseThrow(() -> new UsernameNotFoundException("User with this phone number doesn't exist."));
        if (user.getOtpExpireTime().isBefore(LocalDateTime.now())) {
            throw new RestStandardException(403, "OTP has expired. Request a new one.");
        }
        boolean valid = user.getOtp().equals(otpValidationDto.getOtp());
        if (!valid)
            throw new RestStandardException(403, "Incorrect OTP. Please try again.");
    }

    @Override
    public BasicUserDetailsWithTokenDto getBasicUserDetailsWithTOken(UserRequestDto userRequestDto) {
        User user = userRepository.findByPhone(userRequestDto.getPhone())
                .orElseThrow(() -> new UsernameNotFoundException("User with this phone number doesn't exist."));
        BasicUserDetailsWithTokenDto basicUserDetailsWithTokenDto = userMapper.tobaBasicUserDetailsWithTokenDto(user);
        basicUserDetailsWithTokenDto.setToken(JwtService.generateToken(user));
        return basicUserDetailsWithTokenDto;
    }
}
