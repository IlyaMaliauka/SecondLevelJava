package com.epam.automation.exceptions;

import java.util.ArrayList;

public class University {
    private ArrayList<Faculty> university = new ArrayList<>();
    private String name;
    private String rectorName;
    private double averageUniversityMark;

    public void addFacultyToUniversity (Faculty faculty) { university.add(faculty);}

    public void displayUniversity() throws Exception {
        if (university.isEmpty()) {
            throw new Exception("No groups on the Faculty!");
        }
        System.out.println("\n" + name+
                ", Rector: " + rectorName);
    }

    public University(String name, String rectorName) {
        this.name = name;
        this.rectorName = rectorName;
    }

    @Override
    public String toString() {
        return name+
                ", Rector: " + rectorName;
    }

    public void displayAverageUniversityMark() {
            for (Faculty c : university) {
                averageUniversityMark += c.getAverageFacultyMark();
            }
            averageUniversityMark /= university.size();
            System.out.println("Average history mark of the " + name + " is " + averageUniversityMark);
        }
    }
