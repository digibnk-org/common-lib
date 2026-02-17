package com.digibnk.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private T data;
    private String message;
    private LocalDateTime timestamp;
    private int status;
    private boolean success;

    public static <T> BaseResponse<T> success(T data, String message) {
        return BaseResponse.<T>builder()
                .data(data)
                .message(message)
                .timestamp(LocalDateTime.now())
                .status(200)
                .success(true)
                .build();
    }
    
    public static <T> BaseResponse<T> success(T data) {
        return success(data, "Operation successful");
    }
}
