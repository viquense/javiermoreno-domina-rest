/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javiermoreno.dominaspring.services;

import com.javiermoreno.dominaspring.domain.CuentaAhorro;
import com.javiermoreno.dominaspring.domain.CuentaCorriente;
import com.javiermoreno.dominaspring.domain.Movimiento;
import com.javiermoreno.dominaspring.domain.ProductoFinanciero;
import com.javiermoreno.dominaspring.framework.BusinessException;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author curs
 */
public class GestionProductosServImplFake implements GestionProductosServ {

    public static final BigDecimal TRANS_MAX_IMPORTE = new BigDecimal("1000");
    
    public ProductoFinanciero obtenerProducto(String codigo) {
        return new CuentaCorriente(codigo, new BigDecimal("1000"), 
                                   new BigDecimal("0.01"));
        
    }

    public Movimiento ingresar(String codigoDestino, BigDecimal importe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Movimiento reintegrar(String codigoOrigen, BigDecimal importe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Movimiento transferir(String codigoOrigen, String codigoDestino, BigDecimal importe) {
        if (importe.compareTo(TRANS_MAX_IMPORTE) > 0) {
            throw new BusinessException("Importe máximo alcanzado.");
        }
        CuentaCorriente c1 = new CuentaCorriente(codigoOrigen,
                                     new BigDecimal(500), new BigDecimal(100));
        CuentaCorriente c2 = new CuentaCorriente(codigoDestino, 
                                    new BigDecimal(500), new BigDecimal(100));
        c1.transferir(c2, importe);
        Movimiento mov = new Movimiento(0, c1, new Date(), importe);
        return mov;
    }
    
}
