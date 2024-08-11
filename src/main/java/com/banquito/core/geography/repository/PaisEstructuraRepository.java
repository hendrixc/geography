package com.banquito.core.geography.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.core.geography.model.PaisEstructura;
import com.banquito.core.geography.model.PaisEstructuraPK;

public interface PaisEstructuraRepository extends JpaRepository<PaisEstructura, PaisEstructuraPK>{

}
