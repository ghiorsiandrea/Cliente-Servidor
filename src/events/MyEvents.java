package events;

import java.awt.*;
import javax.swing.*;

public class MyEvents extends JFrame{

    public MyEvents(){
        setTitle("Buttons and Events");
        setBounds(700,300,500,300);
        LaminaBotones milaminaBotones = new LaminaBotones();
        add(milaminaBotones);
    }

}

class LaminaBotones extends JPanel {

}