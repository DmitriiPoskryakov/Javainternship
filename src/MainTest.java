import java.io.File;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        File from = new File("data/test.txt");
        File toIo = new File("CopyIo/test.txt");
        File toNio = new File("CopyNio/test.txt");
        File toFiles = new File("CopyFiles/test.txt");
        CopyIo testIo = new CopyIo(from, toIo);
        CopyNio testNio = new CopyNio(from, toNio);
        CopyFiles testFiles = new CopyFiles(from, toFiles);

        try {
            testIo.copy();
            testNio.copy();
            testFiles.copy();
            System.out.println("File copied successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
