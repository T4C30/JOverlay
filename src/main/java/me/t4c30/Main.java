package me.t4c30;

import java.awt.AWTException;

/**
 * Clase lanzadora del hilo principal de la aplicación
 * @author T4C30
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //TODO: Incorporar una comprobacion ficheros
        if (java.awt.GraphicsEnvironment.isHeadless()) {
            // No tiene capacidad grafica
            System.err.println("No esta disponible en modo sin cabecera");
            System.exit(1);
        }
        new Overlay();
        try {
            new Bandeja();
        } catch (AWTException ex) {
            // TODO: Mensaje de alerta por diez segundos y la opcion de enviar problemas
            System.err.println(ex.getMessage());
        }
    }
}