package com.banquito.core.geography.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GEN_PAIS_ESTRUCTURA")
@Getter
@Setter
public class PaisEstructura implements Serializable {

    @EmbeddedId
    private PaisEstructuraPK pk;
    @Column(name = "NOMBRE", length = 64, nullable = false)
    @NotNull
    private String nombre;
    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    @ManyToOne
    @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS", insertable = false, updatable = false)
    private Pais pais;

    public PaisEstructura() {
    }

    public PaisEstructura(PaisEstructuraPK pk) {
        this.pk = pk;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
        PaisEstructura other = (PaisEstructura) obj;
        if (pk == null) {
            if (other.pk != null)
                return false;
        } else if (!pk.equals(other.pk))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PaisEstructura [pk=" + pk + ", nombre=" + nombre + ", version=" + version + "]";
    }

}
