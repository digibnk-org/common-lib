package com.digibnk.common.dto.transaction;

public record TransferResponse(
        String transactionId,
        String status
) {}
