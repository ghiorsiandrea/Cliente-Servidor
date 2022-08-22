package streams;

import streams.readingwrittingbyte.ReadingWrittingByte;
import streams.single.Myfilereader;
import streams.single.Myfilereaderbuffered;
import streams.single.Myfilewritter;
import streams.single.Myfilewritterbuffered;

public class Main {

    public static void main(String[] args) {

        // Exercise One, Curso Pildoras Informaticas - Java. Streams I.
        // Accediendo a ficheros. Lectura. Vídeo 152 -

        Myfilereader accessing = new Myfilereader();
        accessing.readd();

        //Exercise Two, Curso Pildoras Informaticas - Streams II.
        // Accediendo a ficheros Escritura. Vídeo 153 -

        Myfilewritter writting = new Myfilewritter();
        writting.write();

        Myfilewritter writting2 = new Myfilewritter();
        writting2.writeNonExistentFile();

        //Exercise Tree, Curso Pildoras Informaticas - Streams III.
        // Usando buffers. Vídeo 154 -

        Myfilereaderbuffered accessing2 = new Myfilereaderbuffered();
        accessing2.readd();

        Myfilewritterbuffered writting3 = new Myfilewritterbuffered();
        writting3.write();

        Myfilewritterbuffered writting4 = new Myfilewritterbuffered();
        writting4.writeNonExistentFile();

        // Exercise Four, Curso Pildoras Informaticas - Streams IV.
        // Leyendo archivos. Streams Byte I. Vídeo 155

        //Exercise Five, Curso Pildoras Informaticas - Streams IV. Streams V.
        // Escribiendo archivos Streams Byte II. Vídeo 156


        ReadingWrittingByte readingWrittingByte = new ReadingWrittingByte();
        readingWrittingByte.writee(readingWrittingByte.readdd());
    }
}
