/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javiermoreno.rest;

import com.javiermoreno.dominaspring.domain.ProductoFinanciero;
import com.javiermoreno.dominaspring.services.GestionProductosServ;
import com.javiermoreno.dominaspring.services.GestionProductosServFactory;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
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
@Api(value = "/producto", 
     description = "Manipulación de productos financieros.")
public class ProductosCtrl {
    
    private GestionProductosServ servicio;

    public ProductosCtrl() {
        this.servicio = GestionProductosServFactory.crear();
    }

    @GET
    @Path("/test/{mensaje}")
    @Produces("application/json;charset=utf-8")
    public String test(@PathParam("mensaje") String echo, 
                       @QueryParam("contador") int contador) {
        return contador + " " + echo.toUpperCase();
    }
    
    @GET
    @Path("/{codigo}")
    @Produces({"application/json;charset=utf-8"})
    @ApiOperation(value="Recupera la información de un producto.", 
                  notes="Versión alpha. Api sujeta a cambios.")
    @ApiResponses(value =   {
        @ApiResponse(code = 200, message = "Producto encontrado."),
        @ApiResponse(code = 404, message = "Código de producto no encontrado.")
    })
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
