package com.digibnk.common.security;

public record JwtUser(
        String userId,
        String username,
        String role
) {}
