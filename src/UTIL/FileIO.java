package UTIL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    // en metoder der læser i csv-filen.

    public ArrayList<String> readData(String path, ArrayList<String> arraylistName) { // add Arraylist String to this part.
        File file = new File(path); // tell the system where it shall found the file
        try {
            Scanner sc = new Scanner(file); // scanner there read the file
            sc.nextLine(); // jump over the header
            while (sc.hasNextLine()) { // so loong there are lines it will read the file.
                String line = sc.nextLine(); // make the line to a string and go to the next.
                arraylistName.add(line); // this adds the lines it had read to the arraylist
            }

        } catch (FileNotFoundException e) {  // a catch to see if the file not found, so the system not just crash but tell us what it's wrong.
            System.out.println("File not found!");
        }
        return arraylistName; // returner the information.

    }
}