package com.inaing.inaeats.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestStandardResponse<T> {

    private final int status;
    private final T detail;
    private final String timestamp;

    public RestStandardResponse(int status, T detail) {
        this.status = status;
        this.detail = detail;
        this.timestamp = LocalDateTime.now().toString();
    }

    public static <T> RestStandardResponse<T> success(T detail) {
        return new RestStandardResponse<T>(200, detail);
    }

    public static <T> RestStandardResponse<T> of(int status, T detail) {
        return new RestStandardResponse<T>(status, detail);
    }
}
