package threads;

import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsingThreads {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame marco = new ReboundFramework();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class BallThreads implements Runnable {

    private final Ball ball;
    private final Component component;

    public BallThreads(Ball oneBall, Component oneComponent) {
        ball = oneBall;
        component = oneComponent;
    }

    /**
     * Here we need to put the task that we need that be simultaneous
     */
    @Override
    public void run() {
        for (int i = 1; i <= 3000; i++) {
            ball.mueve_pelota(component.getBounds());
            component.paint(component.getGraphics());
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Ball {

    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    // Mueve la pelota invirtiendo posici�n si choca con l�mites
    public void mueve_pelota(Rectangle2D limites) {
        x += dx;
        y += dy;

        if (x < limites.getMinX()) {
            x = limites.getMinX();
            dx = -dx;
        }

        if (x + TAMX >= limites.getMaxX()) {
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }

        if (y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }
        if (y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }
    }

    //Forma de la pelota en su posici�n inicial
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }

}

// L�mina que dibuja las pelotas----------------------------------------------------------------------

class LeafBall extends JPanel {

    //A�adimos pelota a la l�mina

    private final ArrayList<Ball> pelotas = new ArrayList<>();

    public void add(Ball b) {
        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : pelotas) {
            g2.fill(b.getShape());
        }
    }
}

//Marco con l�mina y botones------------------------------------------------------------------------------

class ReboundFramework extends JFrame {

    public ReboundFramework() {
        setBounds(600, 300, 400, 350);
        setTitle("Rebotes");
        lamina = new LeafBall();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();
        ponerBoton(laminaBotones, "Dale!", evento -> {
            try {
                comienza_el_juego();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        ponerBoton(laminaBotones, "Salir", evento -> System.exit(0));
        add(laminaBotones, BorderLayout.SOUTH);
    }

    //Ponemos botones

    public void ponerBoton(Container c, String titulo, ActionListener oyente) {
        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }

    //A�ade pelota y la bota 1000 veces

    private final LeafBall lamina;

    public void comienza_el_juego() throws InterruptedException {
        Ball ball = new Ball();
        lamina.add(ball);
        Runnable r = new BallThreads(ball, lamina);
        Thread t = new Thread(r);
        t.start();
    }
}