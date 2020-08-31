package com.epam.automation.exceptions;

import java.util.ArrayList;

public class Faculty {

    private ArrayList<Group> faculty = new ArrayList<>();
    private String name;
    private String deanName;
    private double averageFacultyMark = 0;

    public void addGroupToFaculty (Group group) { faculty.add(group);}

    public void displayFaculty() throws Exception {
        if (faculty.isEmpty()) {
            throw new Exception("No groups on the Faculty!");
        }
        System.out.println(faculty);
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
        return "Faculty{" +
                "name='" + name + '\'' +
                ", deanName='" + deanName + '\'' +
                '}';
    }

    public void displayAverageFacultyMark () {
        for (Group c : faculty) {
            averageFacultyMark += c.getAverageMark();
        }
        averageFacultyMark /= faculty.size();
        System.out.println("Average history mark of the faculty is " + averageFacultyMark);


    }
}
