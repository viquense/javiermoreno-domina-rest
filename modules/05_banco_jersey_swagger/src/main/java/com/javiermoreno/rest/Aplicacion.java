/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javiermoreno.rest;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author curs
 */
@ApplicationPath("/api/*")
public class Aplicacion extends Application {

@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        resources.add(com.wordnik.swagger.jaxrs.JaxrsApiReader.class);
        resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);        
        resources.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
        resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
        resources.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
        addRestResourceClasses(resources);
        return resources;
    }


    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.javiermoreno.rest.ProductosCtrl.class);
    }    
}













