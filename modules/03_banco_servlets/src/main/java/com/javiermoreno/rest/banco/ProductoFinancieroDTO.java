/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javiermoreno.rest.banco;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javiermoreno.dominaspring.domain.ProductoFinanciero;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author curs
 */
public class ProductoFinancieroDTO {
            
    @JsonProperty("code")
    private String codigo;
    @JsonProperty("amount")
    private BigDecimal saldo;
    
    private Map<String, String> mensaje = new HashMap<String,String>();
    
    public ProductoFinancieroDTO(ProductoFinanciero original) {
        this.codigo = original.getCodigo();
        this.saldo = original.getSaldo();
        this.mensaje.put("es", "Buenos días.");
        this.mensaje.put("ca", "Bon dia.");        
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
    
    
    
    
}



