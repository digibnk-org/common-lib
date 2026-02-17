package com.digibnk.common.dto.transaction;

import java.math.BigDecimal;

public record TransferRequest(
        String fromAccount,
        String toAccount,
        BigDecimal amount
) {}
