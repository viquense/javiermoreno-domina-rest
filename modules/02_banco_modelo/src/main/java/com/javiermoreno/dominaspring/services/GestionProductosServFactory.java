/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javiermoreno.dominaspring.services;

/**
 *
 * @author curs
 */
public class GestionProductosServFactory {

    private static GestionProductosServImplFake instancia =
            new GestionProductosServImplFake();
    
    public static GestionProductosServ crear() {
        return instancia;
    }
    
}
