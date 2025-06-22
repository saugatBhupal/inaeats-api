package com.inaing.inaeats.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.inaing.inaeats.entity.enums.Gender;
import com.inaing.inaeats.entity.enums.Role;
import com.inaing.inaeats.entity.enums.UserType;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "phone") })
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String fullname;
    private String email;

    @Nonnull
    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date dob;
    private Integer age;

    @Enumerated(EnumType.STRING)

    @Column(name = "user_type")
    private UserType userType = UserType.USER;
    private String otp;
    @Column(name = "otp_expire_time")
    private LocalDateTime otpExpireTime;

    @Nonnull
    @Column(nullable = false, name = "has_registered")
    private Boolean hasRegistered = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role userRole = Role.NULL;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String authority = (userRole == null) ? Role.NULL.toString() : userRole.toString();
        return List.of(new SimpleGrantedAuthority(authority));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return phone;
    }
}
