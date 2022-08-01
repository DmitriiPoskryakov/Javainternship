import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class WithFiles implements CopyInterface {
    private final File source;
    private final File dest;

    public WithFiles(File from, File to) {
        this.source = from;
        this.dest = to;
    }

    public void copy() throws IOException {

        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Копирование завершено.");
    }

    /*public void copy(StandardCopyOption x) throws IOException {

        Files.copy(source.toPath(), dest.toPath(), x);

    }*/
}
