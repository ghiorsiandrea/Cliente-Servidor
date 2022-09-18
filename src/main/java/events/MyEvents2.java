package main.java.events;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyEvents2 extends JFrame {

    public MyEvents2() {
        setTitle("Buttons and Events2");
        setBounds(500, 100, 300, 200);
        LaminaBotones2 milaminaBotones2 = new LaminaBotones2();
        add(milaminaBotones2);
    }
}

class LaminaBotones2 extends JPanel {

    //SEGUNDO EVENTO - OBJETO FUENTE
    JButton bluebutton = new JButton("Blue");
    JButton yellowbutton = new JButton("Yellow");
    JButton redbutton = new JButton("Red");

    public LaminaBotones2() {
        // PRIMER EVENTO - OBJETO EVENTO
        add(bluebutton);
        add(yellowbutton);
        add(redbutton);

        ColorFondo blue = new ColorFondo(Color.BLUE);
        ColorFondo yellow = new ColorFondo(Color.YELLOW);
        ColorFondo red = new ColorFondo(Color.RED);

        bluebutton.addActionListener(blue);
        yellowbutton.addActionListener(yellow);
        redbutton.addActionListener(red);
    }

    // TERCER EVENTO - OBJETO LISTENER - COLOR FONDO
    private class ColorFondo implements ActionListener {

        private Color colordeFondo;

        public ColorFondo(Color c) {
            colordeFondo = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // When is a non-static and inner class this class contain a reference to this (outer class)
            // setBackground(colordeFondo);
            LaminaBotones2.this.setBackground(colordeFondo);
        }
    }

}


