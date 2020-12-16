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

    public static ArrayList<String> readGroupsToArray(String filepath) {
        ArrayList<String> groups = new ArrayList<>();

        try {
            File myObj = new File(filepath);

            StringBuilder group = new StringBuilder();

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                if (line.equals("")) {
                    groups.add(group.toString());

                    group = new StringBuilder();
                }
                else {
                    group.append(line);
                }
            }

            groups.add(group.toString());
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return groups;
    }

    public static ArrayList<String> readGroupsIndividualsToArray(String filepath) {
        ArrayList<String> groups = new ArrayList<>();

        try {
            File myObj = new File(filepath);

            StringBuilder group = new StringBuilder();

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                if (line.equals("")) {
                    groups.add(group.toString());

                    group = new StringBuilder();
                }
                else {
                    if (!group.toString().equals("")) {
                        group.append(",");
                    }
                    group.append(line);
                }
            }

            groups.add(group.toString());
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return groups;
    }
}
