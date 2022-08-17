package streams;

import java.io.FileReader;
import java.io.IOException;

/**
 * This class was created attending the course of Streams - Java - of "Pildoras Informaticas"
 */

public class Myfilereader {

    public void readd() {
        try {
            FileReader entrada = new FileReader("/home/dalga/andrea/proyectos/readme.txt");
            int c = 0;
            while (c != -1) {
                c = entrada.read();
                char letra =(char) c;
                System.out.print(letra);
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}
