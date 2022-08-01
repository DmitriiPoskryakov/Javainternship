import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class WithNio implements CopyInterface {
    private final File src;
    private final File dest;

    public WithNio(File src, File dest) {
        this.src = src;
        this.dest = dest;
    }

    public void copy() throws IOException {
        try (FileChannel sourceChannel = new FileInputStream(src).getChannel(); FileChannel destChannel = new FileOutputStream(dest).getChannel()) {
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        }
        System.out.println("Копирование завершено.");
    }

}
