package UTIL;

import java.util.Scanner;

public class TextUI {


    public String promptText() {
        System.out.println(" Please enter a dato by month/day/year. fx 12/04/2025");
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        return userInput;
    }
}
