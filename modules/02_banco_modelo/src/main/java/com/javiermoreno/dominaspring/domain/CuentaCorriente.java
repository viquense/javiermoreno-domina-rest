/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javiermoreno.dominaspring.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.MessageFormat;

import com.javiermoreno.dominaspring.framework.BusinessException;

public class CuentaCorriente extends ProductoFinanciero implements Serializable {

    private static final long serialVersionUID = 1L;

    public CuentaCorriente() {
        super();
    }

    public CuentaCorriente(String codigo, BigDecimal saldo, BigDecimal interesAnual) {
        super(codigo, saldo, interesAnual);
    }

    public void transferir(ProductoFinanciero destino,
            BigDecimal importe) {
        if (this.equals(destino) == true) {
            throw new IllegalArgumentException("Transferencia entre una única cuenta.");
        }

        if (this.getSaldo().compareTo(importe) < 0) {
            throw new BusinessException(MessageFormat.format("Importe {0} debería de ser superior a 0.", importe));
        }

        BusinessException.comprobar(importe.compareTo(this.getSaldo()) > 0, "Saldo insuficiente para transferir el importe {0}.", importe);

        this.setSaldo(this.getSaldo().subtract(importe));
        destino.setSaldo(destino.getSaldo().add(importe));
    }

}
