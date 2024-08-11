package com.banquito.core.geography.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class PaisEstructuraPK implements Serializable{

    @Column(name = "COD_PAIS", length = 2, nullable = false)
    @NotNull
    private String codigoPais;
    @Column(name = "NIVEL", length = 2, nullable = false)
    @NotNull
    private Integer nivel;
}
