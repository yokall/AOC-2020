package com.yokall.dayone;

import java.util.List;

public class ExpenseFixer {
    public int fixExpenses(List<Integer> figures) {
        for (int i = 0; i < figures.size() - 1; i++) {
            for (int j = 0; j < figures.size() - i; j++) {
                if (figures.get(i) + figures.get(j) == 2020) {
                    return figures.get(i) * figures.get(j);
                }
            }
        }

        return 0;
    }

    public int fixExpensesPartTwo(List<Integer> figures) {
        for (int i = 0; i < figures.size() - 2; i++) {
            for (int j = i + 1; j < figures.size() - 1; j++) {
                for (int k = j + 1; k < figures.size(); k++) {
                    if (figures.get(i) + figures.get(j) + figures.get(k) == 2020) {
                        return figures.get(i) * figures.get(j) * figures.get(k);
                    }
                }
            }
        }

        return 0;
    }
}
