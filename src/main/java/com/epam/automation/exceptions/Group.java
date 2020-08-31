package com.epam.automation.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private String groupHeadName;
    private String groupHeadMobileNumber;
    private String groupEmail;
    private double averageMark = 0;
    private ArrayList<Student> group = new ArrayList<>();

    public void addToGroup (Student student) { group.add(student);}

    public void displayGroup () throws Exception {
        if (group.isEmpty()) {
            throw new Exception("No students in the group");
        }
        System.out.println("Group " + name + ", Group head: " + groupHeadName + "Mobile number: " + groupHeadMobileNumber +
                ", Group e-mail: " + groupEmail + "\nStudents: " + group);
    }

    public void getAverageGroupMark () {

        for (Student c : group) {
           averageMark += c.getHistoryMark();
        }
        averageMark /= group.size();
        System.out.println("Average history mark of the group is " + averageMark);
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
