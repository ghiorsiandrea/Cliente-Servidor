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

// TERCER EVENTO - OBJETO LISTENER - LA LAMINA
class LaminaBotones extends JPanel implements ActionListener {

    //SEGUNDO EVENTO - OBJETO FUENTE
    JButton bluebutton = new JButton("Blue");
    JButton yellowbutton = new JButton("Yellow");
    JButton redbutton = new JButton("Red");

    public LaminaBotones() {
        // PRIMER EVENTO - OBJETO EVENTO
        add(bluebutton);
        add(yellowbutton);
        add(redbutton);
        bluebutton.addActionListener(this);
        yellowbutton.addActionListener(this);
        redbutton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object buttonpressed = e.getSource();

        if (buttonpressed == bluebutton) {
            setBackground(Color.blue);
        }
        if (buttonpressed == yellowbutton) {
            setBackground(Color.yellow);
        } else {
            setBackground(Color.red);
        }
    }
}