package events;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyEvents extends JFrame {

    public MyEvents() {
        setTitle("Buttons and Events");
        setBounds(700, 300, 500, 300);
        LaminaBotones milaminaBotones = new LaminaBotones();
        add(milaminaBotones);
    }

}

// TERCER EVENTO - LA LAMINA ES EL LISTENER
class LaminaBotones extends JPanel implements ActionListener {

    //SEGUNDO EVENTO - OBJETO FUENTE
    JButton bluebutton = new JButton("Blue");

    public LaminaBotones() {
        // PRIMER EVENTO
        add(bluebutton);
        bluebutton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}