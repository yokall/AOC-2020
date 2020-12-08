package com.yokall.dayone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ExpenseFixerTest {
    ExpenseFixer expenseFixer = new ExpenseFixer();

    List<Integer> figures = new ArrayList<>(
            List.of(1721,
                    979,
                    366,
                    299,
                    675,
                    1456)
    );

    @Test
    void fixExpenses() {
        int actual = expenseFixer.fixExpenses(figures);

        int expected = 514579;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void fixExpensesPart2() {
        int actual = expenseFixer.fixExpensesPartTwo(figures);

        int expected = 241861950;

        Assertions.assertEquals(expected, actual);
    }
}