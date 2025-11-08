package me.t4c30;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;

import me.t4c30.widget.Bateria;
import me.t4c30.widget.Reloj;

/**
 * Overlay que se mostrara en superposicion
 * @author T4C30
 * @version 1.0
 */
public class Overlay extends JDialog {
    /**
     * Personalizacion de un panel que guarda los Widgets
     * @author T4C30
     * @version v1.0
     */
    private class Pane extends JPanel {
        /**
        * Constructor por defecto.
        * Añade todos las propiedades basicas
        */
        public Pane() {
            add(new Reloj());
            add(new Bateria());
            setOpaque(false);
        }
    }
    
    /**
     * Constructor por defecto.
     * Añade todos las propiedades basicas
     */
    public Overlay() {
        setSize(300,25);
        add(new Pane());
        setAlwaysOnTop(true);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
    }
}
