package me.t4c30.widget;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.Timer;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PowerSource;

/**
 * Widget de texto de la bateria disponible/restante
 * @author T4C30
 * @version 1.0.0.1
 */
public class Bateria extends JLabel{

    private PowerSource ps;
    private Timer temporizador;

    /**
     * Constructor por defecto.
     * Añade todos las propiedades basicas.
     * Bateria que se actualiza los campos al segundo
     */
    public Bateria() {
        if (informacionSistema()==null) {
            return;
        }
        temporizador = new Timer(1000, (ActionEvent e) -> {
            setText("| Bateria: "+getBateria()+ "%, quedan " + getTiempo() + " min");
        });
        temporizador.start();
        setForeground(Color.GREEN);
        setOpaque(false);
        setVisible(true);
    }

    /**
     * Obtienes la bateria disponible del equipo
     * @return Bateria de restante del equipo normalizado a porcentaje
     */
    public double getBateria() {
        //TODO: Mejorar la recuperacion de la bateria a las baterias disponible (Mando, Raton)
        ps = informacionSistema();
        double capacidaActual = ps.getCurrentCapacity();
        double capacidaMaxima = ps.getMaxCapacity();
        return Math.round((capacidaActual/capacidaMaxima)*100); 
    }

    /**
     * Obtienes el tiempo en minutos de la bateria, ya se por carga o por descarga de esta
     * @return
     */
    public long getTiempo() {
        ps = informacionSistema();
        double tiempoRestanteSegundos = ps.getTimeRemainingInstant();
        return (long) (tiempoRestanteSegundos / 60);
    }

    /**
     * Obtienes la informacion del sistema de la bateria para ser manejada en la clase
     * @return el objeto bateria con su informacion o nulo si esta vacio
     */
    private PowerSource informacionSistema(){
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        // TODO: Mejorar lógica
        if (hal.getPowerSources().isEmpty()) {
            return null;
        }
        return hal.getPowerSources().get(0);
    }


}