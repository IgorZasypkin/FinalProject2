package org.example.id.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@Value
@Builder
public class Authentication {
    private final long id;
    private final List<String> roles;
    private final long stationId;

    public boolean hasRole(final String role) {
        return roles.contains(role);
    }

    public static Authentication anonymous() {
        return Authentication.builder()
                .id(-1)
                .roles(List.of(Roles.ROLE_ANONYMOUS))
                .build();
    }
}