package main.java.streams.single;

import java.io.*;

/**
 * This class was created attending the course of Streams - Java - of "Pildoras Informaticas"
 */

public class Myfilewritterbuffered {

    public void write() {
        String frase = "Esta es una prueba de escritura con BUFFERS";
        try {
            FileWriter escritura = new FileWriter("/home/dalga/andrea/proyectos/Cliente-Servidor/main.java.streams/single/writemebuffer.txt");
            BufferedWriter mybuffer = new BufferedWriter(escritura);
            mybuffer.write(frase);
            mybuffer.flush();
            escritura.close();
        } catch (IOException ex) {
        }
    }

    public void writeNonExistentFile() {
        String frase = "Esta es una prueba de escritura con BUFFERS";
        try {
            FileWriter escritura = new FileWriter("/home/dalga/andrea/proyectos/Cliente-Servidor/main.java.streams/single/writemebuffer2.txt");
            BufferedWriter mybuffer = new BufferedWriter(escritura);
            mybuffer.write(frase);
            mybuffer.flush();
            escritura.close();
        } catch (IOException ex) {
        }
    }
}
