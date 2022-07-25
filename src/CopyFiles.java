import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CopyFiles implements CopyFile {
    private final File source;
    private final File dest;

    public CopyFiles(File from, File to) {
        this.source = from;
        this.dest = to;
    }

    public void copy() throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }
}
