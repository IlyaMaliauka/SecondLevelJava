package com.epam.automation.exceptions;

import com.epam.automation.exceptions.Exceptions.NoStudentsInGroupException;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private String groupHeadName;
    private String groupHeadMobileNumber;
    private String groupEmail;
    private double averageMark = 0;
    private List<Student> group = new ArrayList<>();

    public void addToGroup (Student student) { group.add(student);}

    public void displayGroup () throws NoStudentsInGroupException {
        if (group.isEmpty()) {
            throw new NoStudentsInGroupException("No students in the group");
        }
        System.out.println("Group " + name + ", Group head: " + groupHeadName + " Mobile number: " + groupHeadMobileNumber +
                ", Group e-mail: " + groupEmail + "\n" + "\nStudents: " + group);
    }

    public void getAverageGroupMark () {
        for (Student c : group) {
           averageMark += c.getHistoryMark();
        }
        averageMark /= group.size();
        System.out.println("\nAverage history mark of the group " + name + " is " + averageMark);
    }

    public double getAverageMark() {
        return averageMark;
    }

    public Group(String name, String groupHeadName, String groupHeadMobileNumber, String groupEmail) {
        this.name = name;
        this.groupHeadName = groupHeadName;
        this.groupHeadMobileNumber = groupHeadMobileNumber;
        this.groupEmail = groupEmail;
    }
}
