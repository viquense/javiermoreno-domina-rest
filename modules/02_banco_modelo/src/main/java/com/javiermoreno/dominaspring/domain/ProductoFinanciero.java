package com.javiermoreno.dominaspring.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.MessageFormat;

public class ProductoFinanciero implements Comparable<ProductoFinanciero>, Serializable {

    private static final long serialVersionUID = 1L;

    private static final BigDecimal NUMERO_MESES = new BigDecimal("12");

    private String codigo;
    private BigDecimal saldo;
    private BigDecimal interesAnual;

    public ProductoFinanciero() {
    }

    public ProductoFinanciero(String codigo, BigDecimal saldo, BigDecimal interesAnual) {
        this.codigo = codigo;
        this.saldo = saldo;
        this.interesAnual = interesAnual;
    }

    public void ingresar(BigDecimal importe) {
        if (importe.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(MessageFormat.format("Importe {0} debería de ser superior a 0.", importe));
        }
        saldo = saldo.add(importe);
    }

    public void reintegrar(BigDecimal importe) {
        if (importe.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(MessageFormat.format("Importe {0} debería de ser superior a 0.", importe));
        }
        saldo = saldo.subtract(importe);
    }

    public void actualizarInteresMensual() {
        saldo = saldo.add(saldo.multiply(interesAnual.divide(NUMERO_MESES)));
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(BigDecimal interesAnual) {
        this.interesAnual = interesAnual;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoFinanciero other = (ProductoFinanciero) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    
   

    public int compareTo(ProductoFinanciero o) {
        return this.codigo.compareTo(o.codigo);
    }

}
