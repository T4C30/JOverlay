package org.t4c30;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;

import org.t4c30.widget.GestorWidget;

public class Main {
    public static void main(String[] args) {
        JDialog jf = new GestorWidget();
        SystemTray st = SystemTray.getSystemTray();

        Image image = Toolkit.getDefaultToolkit().getImage("filename"); 

        PopupMenu popup = new PopupMenu();
        TrayIcon trayIcon = new TrayIcon(image, "Imagen", popup);
        trayIcon.setImageAutoSize(true);

        MenuItem exitItem = new MenuItem("Salir");
        exitItem.addActionListener((ActionEvent e) -> {
            st.remove(trayIcon); // Elimina el ícono de la bandeja
            System.exit(0);        // Cierra la aplicación
        });
        popup.add(exitItem);
        
        try {
            st.add(trayIcon);
        } catch (AWTException e) {
            System.err.println("No se pudo agregar el ícono a la bandeja.");
        }
    }
}