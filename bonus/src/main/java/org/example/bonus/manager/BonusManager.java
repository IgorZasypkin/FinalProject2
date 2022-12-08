package org.example.bonus.manager;

import org.example.bonus.dto.BonusRequestDTO;
import org.example.bonus.dto.BonusResponseDTO;
import org.example.bonus.repo.BonusRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class BonusManager {
    private BonusRepository bonusRepository;

    public List<BonusResponseDTO> getAll() {
        return null;
    }

    public BonusResponseDTO getById(Authentication authentication, long id) {
        return null;
    }

    public BonusResponseDTO create(Authentication authentication, BonusRequestDTO requestDTO) {
        return null;
    }

    public BonusResponseDTO update(Authentication authentication, BonusRequestDTO requestDTO) {
        return null;
    }

    public void deleteById(Authentication authentication, long id) {

    }
}