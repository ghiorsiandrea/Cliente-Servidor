package streams.readingwrittingbyte;

import java.io.*;

public class ReadingWrittingByte {
    public void readdd() {
        try {
            FileInputStream readingwritting = new FileInputStream("/home/dalga/andrea/proyectos/Cliente-Servidor/streams/readingwritting/capture.jpg");
            boolean final_ar = false;
            while (!final_ar) {
                int byte_entrada = readingwritting.read();
                if (byte_entrada == -1) {
                    final_ar = true;
                    System.out.println(byte_entrada);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
