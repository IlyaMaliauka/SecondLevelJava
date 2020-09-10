package com.epam.automation.exceptions;

import com.epam.automation.exceptions.Exceptions.NoFacultiesInUniversityException;
import com.epam.automation.exceptions.Exceptions.NoGroupsOnFacultyException;
import com.epam.automation.exceptions.Exceptions.NoStudentsInGroupException;
import com.epam.automation.exceptions.Exceptions.WrongMarkException;

public class Runner {
    public static void main(String[] args) throws WrongMarkException, NoStudentsInGroupException, NoGroupsOnFacultyException, NoFacultiesInUniversityException {
        Student mathStudent1 = new Student(2, "Mikita", "Berazneu", 10, 9, 9, 8);
        Student mathStudent2 = new Student(3, "Vitaly", "Zaharau", 9, 5, 6, 5);
        Student mathStudent3 = new Student(4, "Tsimafei", "Belski", 5, 10, 9, 10);
        Student lawStudent1 = new Student(5, "Pavel", "Sakalou", 4, 8, 6, 4);
        Student lawStudent2 = new Student(6, "Siarhei", "Palavets", 10, 7, 7, 5);
        Student lawStudent3 = new Student(7, "Hleb", "Krasnou", 9, 9, 10, 6);
        Student histStudent1 = new Student(8, "Uladzimir", "Bykau", 5, 10, 6, 9);
        Student histStudent2 = new Student(9, "Herbert G.", "Wells", 10, 10, 6, 10);
        Student histStudent3 = new Student(10, "Usevalad", "Lastouski", 9, 10, 7, 7);

        Group MathFacultyOne = new Group("MF-1", "Mikita Berazneu", "+375297418529", "maths1mail@gmail.com");
        MathFacultyOne.addToGroup(mathStudent1);
        MathFacultyOne.addToGroup(mathStudent2);
        MathFacultyOne.addToGroup(mathStudent3);
        MathFacultyOne.displayGroup();
        MathFacultyOne.getAverageGroupMark();

        Group LawFacultyOne = new Group("LF-1", "Hleb Krasnou", "+375447456712", "law1@gmail.com");
        LawFacultyOne.addToGroup(lawStudent1);
        LawFacultyOne.addToGroup(lawStudent2);
        LawFacultyOne.addToGroup(lawStudent3);

        Group HistFacultyOne = new Group("HF-1", "Usevalad Lastouski", "+375335439981", "history1@gmail.com");
        LawFacultyOne.addToGroup(histStudent1);
        LawFacultyOne.addToGroup(histStudent2);
        LawFacultyOne.addToGroup(histStudent3);

        Faculty math = new Faculty("Mathematical faculty", "Barisau Yauhen");
        math.addGroupToFaculty(MathFacultyOne);
        math.displayFaculty();
        math.displayAverageFacultyMark();

        Faculty law = new Faculty("Law faculty", "Punko Tatsiana");
        law.addGroupToFaculty(LawFacultyOne);

        Faculty history = new Faculty("History faculty", "Ihnatouski Vatslay");
        history.addGroupToFaculty(HistFacultyOne);

        University academyOfPublicAdministration = new University("Academy of Public Administration", "Picheta Uladzimir");
        academyOfPublicAdministration.addFacultyToUniversity(math);
        academyOfPublicAdministration.displayUniversity();
        academyOfPublicAdministration.displayAverageUniversityMark();

    }
}
