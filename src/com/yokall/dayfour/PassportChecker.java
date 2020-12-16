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

                        switch (parts[0]) {
                            case "byr":
                                passport.setByr(parts[1]);
                                break;
                            case "iyr":
                                passport.setIyr(parts[1]);
                                break;
                            case "eyr":
                                passport.setEyr(parts[1]);
                                break;
                            case "hgt":
                                passport.setHgt(parts[1]);
                                break;
                            case "hcl":
                                passport.setHcl(parts[1]);
                                break;
                            case "ecl":
                                passport.setEcl(parts[1]);
                                break;
                            case "pid":
                                passport.setPid(parts[1]);
                                break;
                            case "cid":
                                passport.setCid(parts[1]);
                                break;
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
