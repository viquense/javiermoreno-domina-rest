package com.javiermoreno.dominarest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 * Hello world!
 *
 */
public class AppTest {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/05_banco_jersey/api/")
                                  .path("producto/test/wop")
                                  .queryParam("contador", 100)
                                  .request()
                                  .get();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        
        
    }
}
