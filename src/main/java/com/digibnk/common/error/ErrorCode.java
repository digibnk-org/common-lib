package com.digibnk.common.error;

public enum ErrorCode {

    // ── Account domain
    ACCOUNT_NOT_FOUND,
    ACCOUNT_INACTIVE,
    INSUFFICIENT_FUNDS,
    INVALID_ACCOUNT_TYPE,

    // ── Transaction domain ───────────────────────────────────────────────────
    INVALID_TRANSACTION_TYPE,
    MISSING_SOURCE_ACCOUNT,
    MISSING_TARGET_ACCOUNT,
    TRANSACTION_NOT_FOUND,
    ACCOUNT_SERVICE_UNAVAILABLE,

    // ── Customer domain ──────────────────────────────────────────────────────
    CUSTOMER_NOT_FOUND,
    EMAIL_ALREADY_EXISTS,

    // ── Generic ──────────────────────────────────────────────────────────────
    FRAUD_DETECTED,
    VALIDATION_ERROR,
    SYSTEM_ERROR
}
