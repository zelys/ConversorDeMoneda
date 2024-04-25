package com.zelys.conversordemoneda.logica;

public class ConversorMoneda {
    private String monedaBase, monedaDestino;
    private double cantidad, resultado;
    ConversorER conversorER;

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public void generarRespuesta(double cantidad) {
        ConsultaConversion consulta = new ConsultaConversion();
        this.conversorER = consulta.nuevaConsulta(monedaBase, monedaDestino, cantidad);
        this.resultado = conversorER.conversion_result();
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("""
                ----------------------------------------------
                La cantidad de %.1f %s equivalen a %.1f %s
                ----------------------------------------------""",
                cantidad, monedaBase, resultado, monedaDestino
        );
    }
}