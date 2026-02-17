package com.digibnk.common.dto.account;

import java.math.BigDecimal;

public record AccountDto(
        String accountNumber,
        BigDecimal balance,
        String currency
) {}
