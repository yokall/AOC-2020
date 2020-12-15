package com.yokall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {
    public static ArrayList<String> readLinesToArray(String filepath) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            File myObj = new File(filepath);

            System.out.println("Absolute path: " + myObj.getAbsolutePath());

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                lines.add(myReader.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return lines;
    }
}
