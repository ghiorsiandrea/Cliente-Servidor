package threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class UsingThreads2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame marco = new ReboundFramework2();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class BallThreads2 implements Runnable {

    private final Ball2 ball2;
    private final Component component;

    public BallThreads2(Ball2 oneBall2, Component oneComponent) {
        ball2 = oneBall2;
        component = oneComponent;
    }

    /**
     * Here we need to put the task that we need that be simultaneous
     */
    @Override
    public void run() {
        for (int i = 1; i <= 3000; i++) {
            ball2.mueve_pelota(component.getBounds());
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

class Ball2 {

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

class LeafBall2 extends JPanel {

    //A�adimos pelota a la l�mina

    private final ArrayList<Ball2> pelotas = new ArrayList<>();

    public void add(Ball2 b) {
        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball2 b : pelotas) {
            g2.fill(b.getShape());
        }
    }
}

//Marco con l�mina y botones------------------------------------------------------------------------------

class ReboundFramework2 extends JFrame {

    public ReboundFramework2() {
        setBounds(600, 300, 400, 350);
        setTitle("Rebotes");
        lamina = new LeafBall2();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();
        ponerBoton(laminaBotones, "GO!", evento -> {
            try {
                comienza_el_juego();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        ponerBoton(laminaBotones, "EXIT", evento -> System.exit(0));

        ponerBoton(laminaBotones, "STOP", evento -> detener());

        add(laminaBotones, BorderLayout.SOUTH);
    }

    //Ponemos botones

    public void ponerBoton(Container c, String titulo, ActionListener oyente) {
        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }

    //A�ade pelota y la bota 1000 veces

    private final LeafBall2 lamina;
    Thread t;


    public void comienza_el_juego() throws InterruptedException {
        Ball2 ball2 = new Ball2();
        lamina.add(ball2);
        Runnable r = new BallThreads2(ball2, lamina);
        t = new Thread(r);
        t.start();
    }

    public void detener(){
        t.interrupt();
    }
}