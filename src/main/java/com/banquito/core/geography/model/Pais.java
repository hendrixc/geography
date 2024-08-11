package com.banquito.core.geography.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GEN_PAIS")
@Getter
@Setter
public class Pais implements Serializable{

    @Id
    @Column(name = "COD_PAIS", length = 2, nullable = false)
    @NotNull
    private String codigo;
    @Column(name = "NOMBRE", length = 100, nullable = false)
    @NotNull
    private String nombre;
    @Column(name = "POR_OMISION", length = 1, nullable = false)
    @NotNull
    private String porOmision;
    @Column(name = "CODIGO_TELEFONICO", length = 3, nullable = false)
    @NotNull
    private String codigoTelefonico;
    @Column(name="NACIONALIDAD", length = 50, nullable = false)
    @NotNull
    private String nacionalidad;
    @Version
    @Column(name="version", nullable = false)
    private Integer version;

    public Pais() {}

    public Pais(@NotNull String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pais other = (Pais) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pais [codigo=" + codigo + ", nombre=" + nombre + ", porOmision=" + porOmision + ", codigoTelefonico="
                + codigoTelefonico + ", nacionalidad=" + nacionalidad + ", version=" + version + "]";
    }

    
}
