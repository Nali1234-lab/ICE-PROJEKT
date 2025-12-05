package UTIL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {
    // en metoder der læser i csv-filen.

    public void readData(String path) {
        File file = new File(path);
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}