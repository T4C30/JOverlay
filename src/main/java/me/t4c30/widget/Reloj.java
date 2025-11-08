package me.t4c30.widget;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Widget de texto del reloj
 * @author T4C30
 * @version 1.0
 */
public class Reloj extends JLabel{
    private LocalTime horario = LocalTime.now();
    private final Timer temporizador;

    /**
     * Constructor por defecto.
     * Añade todos las propiedades basicas.
     * Reloj automático que actualiza los campos al segundo
     */
    public Reloj() {
        temporizador = new Timer(1000, (ActionEvent e) -> {
            horario=LocalTime.now();
            setText("Hora: " + horario.getHour()+":"+ horario.getMinute() +":"+horario.getSecond());
        });
        temporizador.start();
        setForeground(Color.GREEN);

        setOpaque(false);
        setVisible(true);
    }

 
}
