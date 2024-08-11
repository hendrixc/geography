package com.banquito.core.geography.controller.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class PaisDTO {

    @NotNull
    private String codigo;
    @NotNull
    private String nombre;
    @NotNull
    private String porOmision;
    private String codigoTelefonico;
    private String nacionalidad;
    private Integer version;

    public PaisDTO(@NotNull String codigo, @NotNull String nombre, @NotNull String porOmision, String codigoTelefonico,
            String nacionalidad, Integer version) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.porOmision = porOmision;
        this.codigoTelefonico = codigoTelefonico;
        this.nacionalidad = nacionalidad;
        this.version = version;
    }

    

}
