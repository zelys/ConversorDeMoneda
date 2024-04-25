package com.zelys.conversordemoneda.logica;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class ConsultaConversion {

    // Método nuevaConsulta que devuelve un objeto de tipo ConversorER
    public ConversorER nuevaConsulta(String monedaBase, String monedaDestino, double cantidad){

        // Definición de la clave de la API y creación de la URI para la consulta
        String API_KEY = "5a9e179bc9894fa070a31c7e";
        URI ruta = URI.create("https://v6.exchangerate-api.com/v6/"
                              +API_KEY+"/pair/"
                              +monedaBase+"/"
                              +monedaDestino+"/"
                              +cantidad+"/"
        );

        // Creación de un cliente HTTP y construcción de la solicitud HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(ruta)
                .build();

        // Manejo de excepciones para la conexión y obtención de la respuesta
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Parseo de la respuesta JSON a un objeto ConversorER usando Gson y retorno del objeto
            return new Gson().fromJson(response.body(), ConversorER.class);
        } catch (IOException |InterruptedException e) {
            // Lanzamiento de una excepción en caso de error de conexión
            throw new RuntimeException("Error de conexión, verifique la URL");
        }
    }
}


