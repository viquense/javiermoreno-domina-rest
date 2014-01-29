package com.javiermoreno.dominaspring.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*
 * En una implementación real deberíamos incluír al usuario que realiza la operación y el tipo. 
 * Probablemente el equals se basaría en un código generado.
 * 
 */
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private ProductoFinanciero origen;

    private Date fecha;

    private BigDecimal importe;

    public Movimiento() {
    }

    public Movimiento(int id, ProductoFinanciero origen, Date fecha,
            BigDecimal importe) {
        super();
        this.id = id;
        this.origen = origen;
        this.fecha = fecha;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductoFinanciero getOrigen() {
        return origen;
    }

    public void setOrigen(ProductoFinanciero origen) {
        this.origen = origen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((origen == null) ? 0 : origen.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Movimiento other = (Movimiento) obj;
        if (fecha == null) {
            if (other.fecha != null) {
                return false;
            }
        } else if (!fecha.equals(other.fecha)) {
            return false;
        }
        if (origen == null) {
            if (other.origen != null) {
                return false;
            }
        } else if (!origen.equals(other.origen)) {
            return false;
        }
        return true;
    }

}
