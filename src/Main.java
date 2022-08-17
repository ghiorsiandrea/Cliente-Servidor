import streams.Myfilereader;
import streams.Myfilewritter;

public class Main {
    public static void main(String[] args) {
        Myfilereader accessing = new Myfilereader();
        accessing.readd();

        Myfilewritter writting = new Myfilewritter();
        writting.write();

        Myfilewritter writting2 = new Myfilewritter();
        writting2.writeNonExistentFile();
    }
}


