package com.epam.automation.exceptions;

import com.epam.automation.exceptions.Exceptions.NoGroupsOnFacultyException;

import java.util.ArrayList;

public class Faculty {

    private ArrayList<Group> faculty = new ArrayList<>();
    private String name;
    private String deanName;
    private double averageFacultyMark = 0;

    public void addGroupToFaculty (Group group) { faculty.add(group);}

    public void displayFaculty() throws NoGroupsOnFacultyException {
        if (faculty.isEmpty()) {
            throw new NoGroupsOnFacultyException("No groups on the Faculty!");
        }
        System.out.println("\nFaculty " + name +
                ", Dean: " + deanName);
    }

    public double getAverageFacultyMark() {
        return averageFacultyMark;
    }

    public Faculty(String name, String deanName) {
        this.name = name;
        this.deanName = deanName;
    }

    @Override
    public String toString() {
        return "Faculty " + name +
                ", Dean: " + deanName;
    }

    public void displayAverageFacultyMark () {
        for (Group c : faculty) {
            averageFacultyMark += c.getAverageMark();
        }
        averageFacultyMark /= faculty.size();
        System.out.println("Average history mark of the " + name + " is " + averageFacultyMark);


    }
}
