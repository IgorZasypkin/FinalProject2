package org.example.bonus.repo;

import org.example.bonus.entity.BonusEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BonusRepository extends JpaRepository<BonusEntity, Long> {

}