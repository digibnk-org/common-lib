package com.digibnk.common.events;

public record FraudResultEvent(
        String transactionId,
        boolean approved,
        String reason
) {}
