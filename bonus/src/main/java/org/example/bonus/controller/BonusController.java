package org.example.bonus.controller;

import org.example.bonus.dto.BonusRequestDTO;
import org.example.bonus.dto.BonusResponseDTO;
import org.example.bonus.manager.BonusManager;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/bonus")
@RequiredArgsConstructor
public class BonusController {
    private BonusManager manager;

    @GetMapping
    public List<BonusResponseDTO> getAll() {
        final List<BonusResponseDTO> responseDTO = manager.getAll();
        return responseDTO;
    }

    @GetMapping("/{id}")
    public BonusResponseDTO getById(
            @RequestAttribute final Authentication authentication,
            @Min(1) @PathVariable final long id
    ) {
        final BonusResponseDTO responseDTO = manager.getById(authentication, id);
        return responseDTO;
    }

    @PostMapping
    public BonusResponseDTO create(
            @RequestAttribute final Authentication authentication,
            @Valid @RequestBody final BonusRequestDTO requestDTO
    ) {
        final BonusResponseDTO responseDTO = manager.create(authentication, requestDTO);
        return responseDTO;
    }
    @PutMapping
    public BonusResponseDTO update(
            @RequestAttribute final Authentication authentication,
            @Valid @RequestBody final BonusRequestDTO requestDTO
    ) {
        final BonusResponseDTO responseDTO = manager.update(authentication, requestDTO);
        return responseDTO;
    }
    @DeleteMapping("/{id}")
    public void deleteById(
            @RequestAttribute final Authentication authentication,
            @Min(1) @PathVariable final long id
    ) {
        manager.deleteById(authentication, id);
    }
}