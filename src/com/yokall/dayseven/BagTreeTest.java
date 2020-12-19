package com.yokall.dayseven;

import com.yokall.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BagTreeTest {

    BagTree bagTree;

    @BeforeEach
    void setUp() {
        bagTree = new BagTree();
    }

    @Test
    void buildTree() {
        ArrayList<String> rules = FileUtils.readLinesToArray("input/DaySevenTest.txt");

        BagTree bagTree = new BagTree();

        bagTree.buildTree(rules);

        Map<String, Bag> actual = bagTree.getTree();

        BagTree expected = testBagTree();

        for (Map.Entry<String, Bag> entry : expected.getTree().entrySet()) {
            assertTrue(actual.containsKey(entry.getKey()), "Actual tree has bag: " + entry.getKey());

            Bag actualBag = actual.get(entry.getKey());
            Bag expectedBag = entry.getValue();

            assertEquals(expectedBag.getName(), actualBag.getName());

            for (Map.Entry<String, Integer> expectedContainsBag : expectedBag.getContains().entrySet()) {
                assertTrue(actualBag.getContains().containsKey(expectedContainsBag.getKey()));

                assertEquals(actualBag.getContains().get(expectedContainsBag.getKey()), expectedContainsBag.getValue(), expectedBag.getName() + " quantity of " + expectedContainsBag.getKey());
            }

            assertEquals(expectedBag.getIsContainedIn().size(), actualBag.getIsContainedIn().size());

            for (String containedByBag : expectedBag.getIsContainedIn()) {
                assertTrue(actualBag.getIsContainedIn().contains(containedByBag));
            }
        }
    }

    @Test
    void howManyBagsContain() {
        int expected = 4;

        BagTree bagTree = testBagTree();

        int actual = bagTree.howManyBagsContain("shiny gold", new ArrayList<>());

        assertEquals(expected, actual);
    }

    @Test
    void howManyBagsAreContainedInside() {
        int expected = 32;

        BagTree bagTree = testBagTree();

        int actual = bagTree.howManyBagsAreContainedInside("shiny gold");

        assertEquals(expected, actual);
    }

    private BagTree testBagTree() {
        BagTree bagTree = new BagTree();

        /*
        light red bags contain 1 bright white bag, 2 muted yellow bags.
        dark orange bags contain 3 bright white bags, 4 muted yellow bags.
        bright white bags contain 1 shiny gold bag.
        muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
        shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
        dark olive bags contain 3 faded blue bags, 4 dotted black bags.
        vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
        faded blue bags contain no other bags.
        dotted black bags contain no other bags.
         */

        Bag lightRed = new Bag("light red");
        HashMap<String, Integer> lightRedContains = new HashMap<>();
        lightRedContains.put("bright white", 1);
        lightRedContains.put("muted yellow", 2);
        lightRed.setContains(lightRedContains);

        Bag darkOrange = new Bag("dark orange");
        HashMap<String, Integer> darkOrangeContains = new HashMap<>();
        darkOrangeContains.put("bright white", 3);
        darkOrangeContains.put("muted yellow", 4);
        darkOrange.setContains(darkOrangeContains);

        Bag brightWhite = new Bag("bright white");
        HashMap<String, Integer> brightWhiteContains = new HashMap<>();
        brightWhiteContains.put("shiny gold", 1);
        brightWhite.setContains(brightWhiteContains);
        List<String> brightWhiteIsContainedIn = new ArrayList<>();
        brightWhiteIsContainedIn.add("light red");
        brightWhiteIsContainedIn.add("dark orange");
        brightWhite.setIsContainedIn(brightWhiteIsContainedIn);

        Bag mutedYellow = new Bag("muted yellow");
        HashMap<String, Integer> mutedYellowContains = new HashMap<>();
        mutedYellowContains.put("shiny gold", 2);
        mutedYellowContains.put("faded blue", 9);
        mutedYellow.setContains(mutedYellowContains);
        List<String> mutedYellowIsContainedIn = new ArrayList<>();
        mutedYellowIsContainedIn.add("light red");
        mutedYellowIsContainedIn.add("dark orange");
        mutedYellow.setIsContainedIn(mutedYellowIsContainedIn);

        Bag shinyGold = new Bag("shiny gold");
        HashMap<String, Integer> shinyGoldContains = new HashMap<>();
        shinyGoldContains.put("dark olive", 1);
        shinyGoldContains.put("vibrant plum", 2);
        shinyGold.setContains(shinyGoldContains);
        List<String> shinyGoldIsContainedIn = new ArrayList<>();
        shinyGoldIsContainedIn.add("bright white");
        shinyGoldIsContainedIn.add("muted yellow");
        shinyGold.setIsContainedIn(shinyGoldIsContainedIn);

        Bag darkOlive = new Bag("dark olive");
        HashMap<String, Integer> darkOliveContains = new HashMap<>();
        darkOliveContains.put("faded blue", 3);
        darkOliveContains.put("dotted black", 4);
        darkOlive.setContains(darkOliveContains);
        List<String> darkOliveIsContainedIn = new ArrayList<>();
        darkOliveIsContainedIn.add("shiny gold");
        darkOlive.setIsContainedIn(darkOliveIsContainedIn);

        Bag vibrantPlum = new Bag("vibrant plum");
        HashMap<String, Integer> vibrantPlumContains = new HashMap<>();
        vibrantPlumContains.put("faded blue", 5);
        vibrantPlumContains.put("dotted black", 6);
        vibrantPlum.setContains(vibrantPlumContains);
        List<String> vibrantPlumIsContainedIn = new ArrayList<>();
        vibrantPlumIsContainedIn.add("shiny gold");
        vibrantPlum.setIsContainedIn(vibrantPlumIsContainedIn);

        Bag fadedBlue = new Bag("faded blue");
        List<String> fadedBlueIsContainedIn = new ArrayList<>();
        fadedBlueIsContainedIn.add("muted yellow");
        fadedBlueIsContainedIn.add("dark olive");
        fadedBlueIsContainedIn.add("vibrant plum");
        fadedBlue.setIsContainedIn(fadedBlueIsContainedIn);

        Bag dottedBlack = new Bag("dotted black");
        List<String> dottedBlackIsContainedIn = new ArrayList<>();
        dottedBlackIsContainedIn.add("dark olive");
        dottedBlackIsContainedIn.add("vibrant plum");
        dottedBlack.setIsContainedIn(dottedBlackIsContainedIn);

        Map<String, Bag> expected = new HashMap<>();
        expected.put(lightRed.getName(), lightRed);
        expected.put(darkOrange.getName(), darkOrange);
        expected.put(brightWhite.getName(), brightWhite);
        expected.put(mutedYellow.getName(), mutedYellow);
        expected.put(shinyGold.getName(), shinyGold);
        expected.put(darkOlive.getName(), darkOlive);
        expected.put(vibrantPlum.getName(), vibrantPlum);
        expected.put(fadedBlue.getName(), fadedBlue);
        expected.put(dottedBlack.getName(), dottedBlack);

        bagTree.setTree(expected);

        return bagTree;
    }
}