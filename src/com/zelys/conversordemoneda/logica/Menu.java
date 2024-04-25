package com.zelys.conversordemoneda.logica;

import com.zelys.conversordemoneda.persistencia.GenerarArchivo;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private final String[] monedas = {"USD","CLP","ARS","BRL","EUR"};

    public void consultaUsuario() throws IOException {
        ConversorMoneda conversor = new ConversorMoneda();
        GenerarArchivo archivo = new GenerarArchivo();
        Scanner entrada = new Scanner(System.in);

        tituloMenu();
        int op = 1;
        while (op != 0) {
            listaOpciones();
            System.out.print(">>> Seleccione la moneda de origen (1-5): ");
            op = Integer.parseInt(entrada.nextLine());
            if (op != 0) {
                conversor.setMonedaBase(monedas[op -1]);
                listaOpciones();
                System.out.print(">>> Seleccione la moneda de destino (1-5): ");
                op = Integer.parseInt(entrada.nextLine());
            }
            if (op != 0) {
                conversor.setMonedaDestino(monedas[op -1]);
                System.out.print("Ingrese la cantidad de ["
                        + conversor.getMonedaBase()
                        + "] a convertir: "
                );
                double cantMoneda = Double.parseDouble(entrada.nextLine());
                conversor.generarRespuesta(cantMoneda);
                // crear archivo
                archivo.guardarJson(conversor.conversorER);
                // mostrar conversión
                System.out.println(conversor);
            }
        }
        // cerrar Scanner
        entrada.close();
    }

    public void tituloMenu() {
        System.out.println("""
                ----------------------------------------------
                   Bienvenidos al conversor de monedas  \s
                ----------------------------------------------"""
        );
    }

    public void listaOpciones() {
        System.out.println("""
                1) [USD] Dólar
                2) [CLP] Peso Chileno
                3) [ARS] Peso Argentino
                4) [BRL] Real Brasileño
                5) [EUR] Euro
                0) Para Salir
                ----------------------------------------------"""
        );
    }
}
