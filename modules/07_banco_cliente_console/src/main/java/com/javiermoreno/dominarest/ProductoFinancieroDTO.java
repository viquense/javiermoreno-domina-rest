/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javiermoreno.dominarest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author curs
 */
public class ProductoFinancieroDTO implements Serializable {
            
    private String codigo;
    private BigDecimal saldo;
    
    private Map<String, String> mensaje = new HashMap<String,String>();
    
    public ProductoFinancieroDTO() {
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

    public Map<String, String> getMensaje() {
        return mensaje;
    }

    public void setMensaje(Map<String, String> mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ProductoFinancieroDTO{" + "codigo=" + codigo + ", saldo=" + saldo + ", mensaje=" + mensaje + '}';
    }

    
}



