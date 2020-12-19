package com.yokall.dayseven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bag {
    private String name;

    private List<String> isContainedIn;

    private HashMap<String, Integer> contains;

    public Bag(String name) {
        this.name = name;

        isContainedIn = new ArrayList<>();
        contains = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Integer> getContains() {
        return contains;
    }

    public void setContains(HashMap<String, Integer> contains) {
        this.contains = contains;
    }

    public List<String> getIsContainedIn() {
        return isContainedIn;
    }

    public void setIsContainedIn(List<String> isContainedIn) {
        this.isContainedIn = isContainedIn;
    }

    public void addIsContainedInBag(String containingBag) {
        this.isContainedIn.add(containingBag);
    }
}
