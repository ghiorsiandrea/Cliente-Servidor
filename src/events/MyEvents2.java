package events;

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

// TERCER EVENTO - OBJETO LISTENER - LA LAMINA
class LaminaBotones2 extends JPanel implements ActionListener {

    //SEGUNDO EVENTO - OBJETO FUENTE
    JButton bluebutton = new JButton("Blue");
    JButton yellowbutton = new JButton("Yellow");
    JButton redbutton = new JButton("Red");

    public LaminaBotones2() {
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
        }

        if (buttonpressed == redbutton) {
            setBackground(Color.red);
        }
    }
}
