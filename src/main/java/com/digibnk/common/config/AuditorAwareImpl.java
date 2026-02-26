package com.digibnk.common.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    private static final String SYSTEM_AUDITOR = "system";

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return Optional.of(SYSTEM_AUDITOR);
        }

        // Keycloak JWT principal: extract preferred_username claim
        if (auth.getPrincipal() instanceof Jwt jwt) {
            String username = jwt.getClaimAsString("preferred_username");
            if (username != null && !username.isBlank()) {
                return Optional.of(username);
            }
            // Fallback to subject (sub claim = Keycloak user UUID)
            return Optional.ofNullable(jwt.getSubject())
                    .map(Optional::of)
                    .orElse(Optional.of(SYSTEM_AUDITOR));
        }

        // Non-JWT authentication (e.g. API key, basic auth)
        if (auth.getName() != null && !auth.getName().isBlank()) {
            return Optional.of(auth.getName());
        }

        return Optional.of(SYSTEM_AUDITOR);
    }
}
