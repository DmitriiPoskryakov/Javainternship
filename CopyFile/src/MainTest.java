import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MainTest {

    public static String inputFrom() {
        System.out.println("Введите путь к файлу который нужно скопировать");
        Scanner sc = new Scanner(System.in);
        String srcPath = sc.nextLine();
        boolean srcExists = Files.exists(Path.of(srcPath));
        if (!srcExists) {
            System.out.println("Файл не найден. Повторите ввод.");
            srcPath = inputFrom();
        }
        return srcPath;
    }

    public static String inputTo(String srcPath) {
        System.out.println("Введите путь к директории в которую нужно скопировать файл");
        Scanner sc = new Scanner(System.in);
        String destDirectory = sc.nextLine();
        String[] n = srcPath.split("/");
        String nameFile = n[n.length - 1];
        String destPath = destDirectory + "/" + nameFile;
        boolean destIsDirectory = Files.isDirectory(Path.of(destDirectory));
        boolean destExists = Files.exists(Path.of(destPath));
        if (!destIsDirectory) {
            System.out.println("Директория не найдена. Повторите ввод.");
            destPath = inputTo(srcPath);
        } else if (destExists) {
            System.out.println("Файл уже существует в указанной директории. Перезаписать? (y/n)");
            String repeat = sc.next();
            if (repeat.contains("y")) {
                System.out.println("Файл перезаписан");
                return destPath;
            } else {
                System.out.println("Копирование отменено");
                return null;
            }
        }
        sc.close();
        return destPath;
    }

    public static void copyWithIo() throws IOException {
        String pathFrom = inputFrom();
        String pathTo = inputTo(pathFrom);
        if (pathFrom != null & pathTo != null) {
            File from = new File(pathFrom);
            File to = new File(pathTo);
            WithIo test = new WithIo(from, to);
            test.copy();
        }
    }

    public static void copyWithNio() throws IOException {
        String pathFrom = inputFrom();
        String pathTo = inputTo(pathFrom);
        if (pathFrom != null & pathTo != null) {
            File from = new File(pathFrom);
            File to = new File(pathTo);
            WithNio test = new WithNio(from, to);
            test.copy();
        }
    }

    public static void copyWithFiles() throws IOException {
        String pathFrom = inputFrom();
        String pathTo = inputTo(pathFrom);
        if (pathFrom != null & pathTo != null) {
            File from = new File(pathFrom);
            File to = new File(pathTo);
            WithFiles test = new WithFiles(from, to);
            test.copy();
        }
    }

    public static void main(String[] args) throws IOException {
        //copyWithIo();
        //copyWithNio();
        copyWithFiles();

    }
}
