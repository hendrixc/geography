package com.banquito.core.geography.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.core.geography.controller.dto.PaisDTO;
import com.banquito.core.geography.mapper.PaisMapper;
import com.banquito.core.geography.model.Pais;
import com.banquito.core.geography.repository.PaisRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaisService {

    private final PaisRepository repository;
    private final PaisMapper mapper;

    public PaisService(PaisRepository repository, PaisMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<PaisDTO> obtainPaises() {
        log.info("Obtaining all 'paises'");
        return this.repository.findAll().stream().map(p -> this.toDTO(p)).collect(Collectors.toList());
    }

    public PaisDTO obtainDefault() {
        log.info("Obtaining default 'pais'");
        return this.toDTO(this.repository.findFirstByPorOmision("S"));
    }

    public void create(PaisDTO pais) {

    }

    private PaisDTO toDTO(Pais pais) {
        return (pais!=null) ? this.mapper.paisToPaisDTO(pais) : null;
    }
}
