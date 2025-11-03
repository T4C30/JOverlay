package org.t4c30.widget;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class GestorWidget extends JDialog {
    private class Pane extends JPanel {
        public Pane() {
            add(new WidgetReloj());
            add(new WidgetBateria());
            setOpaque(false);
        }
    }
    
    public GestorWidget() {
        setSize(300,25);
        add(new Pane());
        setAlwaysOnTop(true);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);
    }
}
