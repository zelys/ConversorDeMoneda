package com.zelys.conversordemoneda.persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zelys.conversordemoneda.logica.ConversorER;

import java.io.FileWriter;
import java.io.IOException;
public class GenerarArchivo {

    String carpeta = "archivosJson/";
    String nombreArchivo;
    public void guardarJson(ConversorER conversor) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        nombreArchivo = conversor.base_code()
                        +"-a-"+conversor.target_code()
                        +".json";
        FileWriter escritura = new FileWriter(carpeta+nombreArchivo.toLowerCase());
        escritura.write(gson.toJson(conversor));
        escritura.close();
    }
}
