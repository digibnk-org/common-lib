package com.digibnk.common.events;

import java.math.BigDecimal;

public record TransactionCreatedEvent(
        String transactionId,
        String fromAccount,
        String toAccount,
        BigDecimal amount
) {}
