package org.t4c30.widget;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PowerSource;

public class WidgetBateria extends JLabel{
    private double bateria;
    private long tiempo;
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();
    private PowerSource ps = hal.getPowerSources().get(0);
    private Timer temporizador;
    private ActionListener accionL;


    public WidgetBateria() {
        accionL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setText("| Bateria: "+getBateria()+ "%, quedan " + getTiempo() + " min");
            }
        };

        temporizador = new Timer(1000, accionL);
        temporizador.start();
        setForeground(Color.GREEN);
        setOpaque(false);
        setVisible(true);

    }



    public double getBateria() {
        si = new SystemInfo();
        hal = si.getHardware();
        ps = hal.getPowerSources().get(0);
        double capacidaActual = ps.getCurrentCapacity();
        double capacidaMaxima = ps.getMaxCapacity();
        return Math.round((capacidaActual/capacidaMaxima)*100); 
    }

    public long getTiempo() {
        si = new SystemInfo();
        hal = si.getHardware();
        ps = hal.getPowerSources().get(0);
        double tiempoRestanteSegundos = ps.getTimeRemainingInstant();
        return (long) (tiempoRestanteSegundos / 60);
    }






    
}
