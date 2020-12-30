package com.yokall.daysix;

import com.yokall.FileUtils;
import com.yokall.StringUtils;

import java.util.ArrayList;

public class YesCounter {
    public int countEachGroupYesAnswers(String filepath) {
        ArrayList<String> groups = FileUtils.readGroupsToArray(filepath);

        int yesCountTotal = 0;
        for (String group : groups) {
            int yesCount = 0;
            ArrayList<Character> questions = new ArrayList<>();
            for (int i = 0; i < group.length(); i++) {
                if(!questions.contains(group.charAt(i))) {
                    questions.add(group.charAt(i));
                    yesCount++;
                }
            }

            yesCountTotal += yesCount;
        }

        return yesCountTotal;
    }

    public int countEveryoneYesAnswers(String filepath) {
        ArrayList<String> groups = FileUtils.readGroupsIndividualsToArray(filepath);

        int yesCountTotal = 0;
        for (String group : groups) {
            int yesCount = 0;
            ArrayList<Character> questions = new ArrayList<>();

            String[] individualYesAnswers = group.split(",");

            if (individualYesAnswers.length == 1) {
                yesCountTotal += individualYesAnswers[0].length();
            }
            else {
                for (int i = 0; i < individualYesAnswers[0].length(); i++) {
                    char currentChar = individualYesAnswers[0].charAt(i);
                    ++yesCount;

                    for (int j = 1; j < individualYesAnswers.length; j++) {
                        if(!StringUtils.stringContainsChar(individualYesAnswers[j], currentChar)) {
                            --yesCount;
                            break;
                        }
                    }
                }

                yesCountTotal += yesCount;
            }
        }

        return yesCountTotal;
    }
}
