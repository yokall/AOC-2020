package com.yokall.dayfour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PassportChecker {
    public int checkPassports(String filename, boolean partTwo) {
        Passport passport = new Passport();
        int validCount = 0;

        try {
            File myObj = new File("input/" + filename);

            System.out.println("Absolute path: " + myObj.getAbsolutePath());

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                if (line.equals("")) {
                    if (passport.isValid(partTwo)) {
                        validCount++;
                    }

                    passport = new Passport();
                }
                else {
                    String[] properties = line.split(" ");

                    for (String property : properties) {
                        String[] parts = property.split(":");

                        if (parts[0].equals("byr")) {
                            passport.setByr(parts[1]);
                        } else if (parts[0].equals("iyr")) {
                            passport.setIyr(parts[1]);
                        } else if (parts[0].equals("eyr")) {
                            passport.setEyr(parts[1]);
                        } else if (parts[0].equals("hgt")) {
                            passport.setHgt(parts[1]);
                        } else if (parts[0].equals("hcl")) {
                            passport.setHcl(parts[1]);
                        } else if (parts[0].equals("ecl")) {
                            passport.setEcl(parts[1]);
                        } else if (parts[0].equals("pid")) {
                            passport.setPid(parts[1]);
                        } else if (parts[0].equals("cid")) {
                            passport.setCid(parts[1]);
                        }
                    }
                }
            }
            myReader.close();

            if (passport.isValid(partTwo)) {
                validCount++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return validCount;
    }
}
