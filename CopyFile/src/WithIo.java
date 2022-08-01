import java.io.*;

public class WithIo implements CopyInterface {
    private final File src;
    private final File dest;

    public WithIo(File src, File dest) {
        this.src = src;
        this.dest = dest;
    }

    public void copy() throws IOException {
        OutputStream os = null;
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

        } finally {
            if (is != null) is.close();
            if (os != null) os.close();
        }
        System.out.println("Копирование завершено.");
    }

}



