import java.io.File;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        File from = new File("data/test.txt");
        File toIo = new File("CopyIo/test.txt");
        File toNio = new File("CopyNio/test.txt");
        File toFiles = new File("CopyFiles/test.txt");
        CopyIo test = new CopyIo(from, toIo);

        try {
            test.copy();
            System.out.println("File copied successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
