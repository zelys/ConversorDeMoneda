package com.zelys.conversordemoneda.logica;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.consultaUsuario();
        /* Excepción en caso de que el usuario ingrese un dato incorrecto
        o ingrese un valor fuera del índice de opciones. */
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Error!, opción no valida.");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("El programa finalizo");
    }
}
