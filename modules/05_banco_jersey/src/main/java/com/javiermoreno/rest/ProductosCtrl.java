/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javiermoreno.rest;

import com.javiermoreno.dominaspring.domain.ProductoFinanciero;
import com.javiermoreno.dominaspring.services.GestionProductosServ;
import com.javiermoreno.dominaspring.services.GestionProductosServFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author curs
 */
@Path("/producto")
public class ProductosCtrl {
    
    private GestionProductosServ servicio;

    public ProductosCtrl() {
        this.servicio = GestionProductosServFactory.crear();
    }

    @GET
    @Path("test/{mensaje}")
    @Produces("application/json")
    public String test(@PathParam("mensaje") String echo, 
                       @QueryParam("contador") int contador) {
        return contador + " " + echo.toUpperCase();
    }
    
    @GET
    @Path("{codigo}")
    @Produces({"application/json"})
    public Response obtenerProducto(
                                    @PathParam("codigo") String codigo) {
        ProductoFinanciero prod = servicio.obtenerProducto(codigo);
        
        Response resp = null;

        if (prod == null) {
            resp = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            ProductoFinancieroDTO dto = new ProductoFinancieroDTO(prod);
            resp = Response.ok(dto).build();
        }
        
        
        return resp;
    }
            
    
    
    
}
