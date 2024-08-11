package com.banquito.core.geography.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.core.geography.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, String>{

    @Transactional(readOnly = true)
    public Pais findFirstByPorOmision(String porOmision); 
}
