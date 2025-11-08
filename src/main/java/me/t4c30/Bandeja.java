package me.t4c30;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

/**
 * Adaptador de un TrayIcon y sus listener
 * @author T4C30
 * @version 1.0 
 */
public class Bandeja extends TrayIcon{
    SystemTray st = SystemTray.getSystemTray();
    Bandeja b = this;

    /**
     * Constructor por defecto.
     * Añade todos las propiedades basicas
     * @throws AWTException Excepcion a controlar en caso de no ser añadido a la bandeja
     */
    public Bandeja() throws AWTException {
        super(new ImageIcon(Main.class.getResource("/Logo_64.png")).getImage());
        setImageAutoSize(true);
        st.add(b);
        // TODO: Hacer un menu para añadir varias opciones o para añadir una que permita añadir automáticamente el inicio de sesion automático
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                st.remove(b);
                System.exit(0);
            }
        });
    }


}
