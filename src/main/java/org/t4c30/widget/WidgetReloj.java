package org.t4c30.widget;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.Timer;

public class WidgetReloj extends JLabel{
    private LocalTime horario = LocalTime.now();
    private Timer temporizador;
    private ActionListener accionL;



    public WidgetReloj() {
        accionL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            horario=LocalTime.now();
                setText("Hora: " + horario.getHour()+":"+ horario.getMinute() +":"+horario.getSecond());
            }
        };

        temporizador = new Timer(1000, accionL);
        temporizador.start();
        setForeground(Color.GREEN);

        setOpaque(false);
        setVisible(true);
    }

 
}
