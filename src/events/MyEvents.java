package events;

import java.awt.*;
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
class LaminaBotones extends JPanel {
    //SEGUNDO EVENTO - OBJETO FUENTE
    JButton bluebutton = new JButton("Blue");

    public LaminaBotones() {
        // PRIMER EVENTO
        add(bluebutton);
    }
}