package com.yokall.dayseven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BagTree {

    private Map<String, Bag> tree = new HashMap<>();

    public Map<String, Bag> getTree() {
        return tree;
    }

    public void setTree(Map<String, Bag> tree) {
        this.tree = tree;
    }

    public void buildTree(ArrayList<String> rules) {
        for (String rule : rules) {
            Bag bag = parseRule(rule);

            if (bag != null) {
                tree.put(bag.getName(), bag);
            }
        }

        for (Map.Entry<String, Bag> bag : tree.entrySet()) {
            for (Map.Entry<String, Integer> containedBags : bag.getValue().getContains().entrySet()) {
                tree.get(containedBags.getKey()).addIsContainedInBag(bag.getKey());
            }
        }
    }

    private Bag parseRule(String rule) {
        String patternString = "^(\\w+\\s\\w+) bags contain (.*)$";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(rule);

        if (matcher.find()) {
            String bagName = matcher.group(1);
            String bagsItContains = matcher.group(2);

            Bag bag = new Bag(bagName);
            bag.setContains(parseQuantityOfBags(bagsItContains));

            return bag;
        }

        return null;
    }

    private HashMap<String, Integer> parseQuantityOfBags(String bagsItContains) {
        String patternString = "(?:(\\d+) (\\w+\\s\\w+))";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(bagsItContains);

        HashMap<String, Integer> bags = new HashMap<>();

        while (matcher.find()) {
            bags.put(matcher.group(2), Integer.parseInt(matcher.group(1)));
        }

        return bags;
    }

    public int howManyBagsContain(String bagName, List<String> containingBags) {
        Bag bag = tree.get(bagName);

        for (String containingBag : bag.getIsContainedIn()) {
            if (!containingBags.contains(containingBag)) {
                containingBags.add(containingBag);

                howManyBagsContain(containingBag, containingBags);
            }
        }

        return containingBags.size();
    }

    public int howManyBagsAreContainedInside(String bagName) {
        Bag bag = tree.get(bagName);

        int count = 0;

        for (Map.Entry<String, Integer> containedBag : bag.getContains().entrySet()) {
            count += containedBag.getValue();
            count += howManyBagsAreContainedInside(containedBag.getKey()) * containedBag.getValue();
        }

        return count;
    }
}
