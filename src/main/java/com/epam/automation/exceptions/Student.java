package com.epam.automation.exceptions;

import com.epam.automation.exceptions.Exceptions.WrongMarkException;

public class Student {
    private int id;
    private String name;
    private String surname;
    private int foreignLangMark;
    private int historyMark;
    private int civilLawMark;
    private int highMathsMark;
    private double averageStudentMark = 0;

    public Student(int id, String name, String surname, int foreignLangMark, int historyMark, int civilLawMark, int highMathsMark) throws WrongMarkException {
        if (historyMark < 0 | historyMark > 10 | foreignLangMark < 0 | foreignLangMark > 10 |
                civilLawMark < 0 | civilLawMark > 10 |
                highMathsMark < 0 | highMathsMark > 10) throw new WrongMarkException("Incorrect mark!");
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.foreignLangMark = foreignLangMark;
        this.historyMark = historyMark;
        this.civilLawMark = civilLawMark;
        this.highMathsMark = highMathsMark;
    }

    public int getForeignLangMark() {
        return foreignLangMark;
    }

    public int getCivilLawMark() {
        return civilLawMark;
    }

    public int getHighMathsMark() {
        return highMathsMark;
    }

    public int getHistoryMark() {
        return historyMark;
    }

    @Override
    public String toString() {
        averageStudentMark += getHistoryMark();
        averageStudentMark += getCivilLawMark();
        averageStudentMark += getForeignLangMark();
        averageStudentMark += getHighMathsMark();
        averageStudentMark /= 4;
        return "\n" + name + " " + surname +
                ", ID: " + id +
                ", Foreign Language Mark: " + foreignLangMark +
                ", History Mark: " + historyMark +
                ", Civil Law Mark: " + civilLawMark +
                ", High Math Mark: " + highMathsMark +
                ", Average Mark: " + averageStudentMark;
    }
}
