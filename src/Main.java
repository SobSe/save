import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите папку c установленной игрой");
        String installDirectory = scanner.nextLine();
        scanner.close();

        Saver saver = new Saver();
        GameProgress gameProgressAlex = new GameProgress(95, 10, 5, 130);
        GameProgress gameProgressSergey = new GameProgress(75, 20, 10, 430);
        GameProgress gameProgressMax = new GameProgress(60, 5, 2, 50);

        saver.saveGame(installDirectory + "/savegames/save1.dat", gameProgressAlex);
        saver.saveGame(installDirectory + "/savegames/save2.dat", gameProgressSergey);
        saver.saveGame(installDirectory + "/savegames/save3.dat", gameProgressMax);

        ArrayList<String> zipFiles = new ArrayList<>();
        zipFiles.add(installDirectory + "/savegames/save1.dat");
        zipFiles.add(installDirectory + "/savegames/save2.dat");
        zipFiles.add(installDirectory + "/savegames/save3.dat");

        saver.zipFiles(installDirectory + "/savegames/zip.zip", zipFiles);
    }
}