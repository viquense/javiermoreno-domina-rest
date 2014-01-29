/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javiermoreno.rest.banco;
 
import com.javiermoreno.dominaspring.services.GestionProductosServFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javiermoreno.dominaspring.domain.ProductoFinanciero;
import com.javiermoreno.dominaspring.services.GestionProductosServ;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author curs
 */
public class ProductosServlet extends HttpServlet {

    private static final Pattern PATTERN_OBTENER_PRODUCTO_POR_CODIGO =
            Pattern.compile("^.*/producto/(\\d{4})$");
    
    private ObjectMapper mapper;
    private GestionProductosServ servicio;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        this.mapper = new ObjectMapper();
        this.servicio = GestionProductosServFactory.crear();
    }
    


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/JSON");
        response.setCharacterEncoding("UTF-8");
        
        String url = request.getRequestURL().toString();
        Matcher matcher = PATTERN_OBTENER_PRODUCTO_POR_CODIGO.matcher(url);
        if (matcher.matches() == true) {
            String codigo = matcher.group(1);
            
            ProductoFinanciero prod = servicio.obtenerProducto(codigo);
            if (prod == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);                
            } else {
                response.setStatus(HttpServletResponse.SC_OK);
               
                ProductoFinancieroDTO dto = 
                        new ProductoFinancieroDTO(prod);
                mapper.writeValue(response.getWriter(), dto);
            }
            
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    } 

}













