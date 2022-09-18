package main.java.streams.single;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class was created attending the course of Streams - Java - of "Pildoras Informaticas"
 */
public class Myfilewritter {
    public void write() {
        String frase = "Esta es una prueba de escritura";
        try {
            FileWriter escritura = new FileWriter("/home/dalga/andrea/proyectos/Cliente-Servidor/main.java.streams/single/writeme.txt");
            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeNonExistentFile() {
        String frase = "Esta es una prueba de escritura";
        try {
            FileWriter escritura = new FileWriter("/home/dalga/andrea/proyectos/Cliente-Servidor/main.java.streams/single/writeme2.txt");
            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
