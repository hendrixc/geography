package com.banquito.core.geography.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GEN_PAIS_ESTRUCTURA")
@Getter
@Setter
public class UbicacionGeografica implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "COD_UBICACION_GEO_INT", nullable=false)
    private Integer codigo;
    @Column(name = "COD_PAIS", length = 2, nullable = false)
    @NotNull
    private String codigoPais;
    @Column(name = "NIVEL", length = 2, nullable = false)
    @NotNull
    private Integer nivel;
    @Column(name = "COD_UBICACION_GEOGRAFICA", length=20, nullable=false)
    @NotNull
    private String codigoUbicacion;
    @Column(name = "NOMBRE", length = 100, nullable = false)
    @NotNull
    private String nombre;
    @Column(name = "COD_UBICACION_GEO_PADRE")
    private Integer codigoUbicacionPadre;
    @Column(name = "CODIGO_AREA_TELEFONO", length=4)
    private String codigoAreaTelefononico;
    @Column(name = "CODIGO_ALTERNO", length=15)
    private String codigoAlterno;
    @Column(name = "CODIGO_POSTAL", length=15)
    private String codigoPostal;
    @Version
    @Column(name="version", nullable = false)
    private Integer version;

    @ManyToOne
    @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS", insertable = false, updatable = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name="COD_UBICACION_GEO_INT", referencedColumnName = "COD_UBICACION_GEO_PADRE", insertable = false, updatable = false)
    private UbicacionGeografica ubicacionPadre;

    @OneToMany(mappedBy = "ubicacionPadre")
    private List<UbicacionGeografica> ubicaciones;

    public UbicacionGeografica() {}

    public UbicacionGeografica(Integer codigo) {
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
        UbicacionGeografica other = (UbicacionGeografica) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UbicacionGeografica [codigo=" + codigo + ", codigoPais=" + codigoPais + ", nivel=" + nivel
                + ", codigoUbicacion=" + codigoUbicacion + ", nombre=" + nombre + ", codigoUbicacionPadre="
                + codigoUbicacionPadre + ", codigoAreaTelefononico=" + codigoAreaTelefononico + ", codigoAlterno="
                + codigoAlterno + ", codigoPostal=" + codigoPostal + ", version=" + version + "]";
    }

    
    
}
