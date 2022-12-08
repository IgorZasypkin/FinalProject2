package org.example.id.repo;

import org.example.id.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;

public interface TokenRepository extends JpaRepository<TokenEntity, String> {
    void deleteByExpireBefore(final Instant instant);
}