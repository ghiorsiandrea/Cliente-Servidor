package events;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyEvents3 extends JFrame {

    public MyEvents3() {
        setTitle("Buttons and Events3");
        setBounds(500, 100, 300, 300);
        LaminaBotones3 milaminaBotones3 = new LaminaBotones3();
        add(milaminaBotones3);
    }
}

class LaminaBotones3 extends JPanel {

    //SEGUNDO EVENTO - OBJETO FUENTE
    JButton bluebutton = new JButton("Blue");
    JButton yellowbutton = new JButton("Yellow");
    JButton redbutton = new JButton("Red");

    public LaminaBotones3() {
        // PRIMER EVENTO - OBJETO EVENTO
        add(bluebutton);
        add(yellowbutton);
        add(redbutton);

        ColorFondo blue = new ColorFondo(Color.BLUE, this);
        ColorFondo yellow = new ColorFondo(Color.YELLOW, this);
        ColorFondo red = new ColorFondo(Color.RED, this);

        bluebutton.addActionListener(blue);
        yellowbutton.addActionListener(yellow);
        redbutton.addActionListener(red);
    }

}

// TERCER EVENTO - OBJETO LISTENER - COLOR FONDO
 class ColorFondo implements ActionListener {

    private Color colordeFondo;
    private JPanel lamina;

    public ColorFondo(Color c, JPanel l) {
        colordeFondo = c;
        lamina = l;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        lamina.setBackground(colordeFondo);
    }
}
