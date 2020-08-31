package com.epam.automation.exceptions;

public class Runner {
    public static void main(String[] args) throws Exception {
        Student kolya = new Student(2, "Kolya", "Vava", 10, 1, 9,4);
        Student vasya = new Student(3, "Vasya", "Vasilyev", 9, 4, 9, 5);
        Student nick = new Student(4, "Nikita", "Blinou", 5, 10, 9, 10);

        Group gup1 = new Group("GUP-1","Носов Николай", "+375297418529", "gup1mail@gmail.com");
        gup1.addToGroup(kolya);
        gup1.addToGroup(vasya);
        gup1.addToGroup(nick);
        gup1.displayGroup();
        gup1.getAverageGroupMark();

        Faculty mfti = new Faculty("Государственное управление и право", "Жабенко Ольга");
        mfti.addGroupToFaculty(gup1);
        try {
            mfti.displayFaculty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        mfti.displayAverageFacultyMark();

        University academyOfPublicAdministration = new University("Academy of Public Administration", "Лаптенок Дмитрий");
        academyOfPublicAdministration.addFacultyToUniversity(mfti);
        try {
            academyOfPublicAdministration.displayUniversity();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
