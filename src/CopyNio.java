import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyNio implements CopyFile {
    private final FileChannel sourceChannel;
    private final FileChannel destChannel;

    public CopyNio(File src, File dest) throws IOException {
        this.sourceChannel = new FileInputStream(src).getChannel();
        this.destChannel = new FileOutputStream(dest).getChannel();
    }

    public void copy() throws IOException {
        try (sourceChannel; destChannel) {
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        }
    }
}
