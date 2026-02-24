package com.digibnk.common.error;

public record ServiceError(
        ErrorCode code,
        String message
) {}
