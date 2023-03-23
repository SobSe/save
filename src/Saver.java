import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Saver {
    public void saveGame(String filePath, GameProgress progress) {
        try(FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(progress);
        } catch (IOException e) {

        }
    }

    public void zipFiles(String zipPath, List<String> zipFiles) {
        try (FileOutputStream fos = new FileOutputStream(zipPath);
             ZipOutputStream zos = new ZipOutputStream(fos)){
            for (String zipFile : zipFiles) {
                File file = new File(zipFile);
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zos.putNextEntry(zipEntry);
                try(FileInputStream fis = new FileInputStream(zipFile)) {
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
                    zos.closeEntry();
                }
                if (file.delete())
                    System.out.println("Удален файл " + file.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
