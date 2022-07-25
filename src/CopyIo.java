import java.io.*;

public class CopyIo implements CopyFile {
    private final InputStream is;
    private final OutputStream os;

    public CopyIo(File src, File dest) throws IOException {
        this.is = new FileInputStream(src);
        this.os = new FileOutputStream(dest);
    }

    public void copy() throws IOException {
        try (is; os) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        }
    }
    
}



