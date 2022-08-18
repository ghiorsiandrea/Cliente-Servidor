package streams.readingwrittingbyte;

import java.io.*;

public class ReadingWrittingByte {
    public int[] readdd() {
        int contador = 0;
        int datos_entrada[] = new int[93193];
        try {
            FileInputStream reading = new FileInputStream(
                    "/home/dalga/andrea/proyectos/Cliente-Servidor/streams/readingwritting/capture.jpg");
            boolean final_ar = false;
            while (!final_ar) {
                int byte_entrada = reading.read();
                if (byte_entrada != -1) {
                    datos_entrada[contador] = byte_entrada;
                } else {
                    final_ar = true;
                }
                contador++;
                System.out.println(byte_entrada);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al acceder a la imagen");
        }

        return datos_entrada;
    }

    public void writee(int datos_nuevo_fichero[]) {

        try {
            FileOutputStream writting = new FileOutputStream(
                    "/home/dalga/andrea/proyectos/Cliente-Servidor/streams/readingwritting/capture_COPIA.jpg");

            for (int i = 0; i < datos_nuevo_fichero.length; i++) {
                writting.write(datos_nuevo_fichero[i]);
            }
            writting.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al crear la imagen");
        }
    }
}
