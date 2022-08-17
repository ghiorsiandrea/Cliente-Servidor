package streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class was created attending the course of Streams - Java - of "Pildoras Informaticas"
 */

public class Myfilereaderbuffered {

    public void readd() {
        try {
            FileReader entrada = new FileReader("/home/dalga/andrea/proyectos/Cliente-Servidor/streams/readmebuffer.txt");
            BufferedReader mybuffer = new BufferedReader(entrada);
            String linea = "";
            while (linea != null) {
                linea = mybuffer.readLine();
                if (linea != null)
                    System.out.println(linea);
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}
