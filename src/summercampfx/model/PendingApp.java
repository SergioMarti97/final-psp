package summercampfx.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import summercampfx.utils.Month;

/**
 * This class is for the student
 *
 * @class PendingApp
 * @author Sergio Martí Torregrosa
 * @date 26/10/2020
 */
public class PendingApp {

    /**
     * The name of the student
     */
    private String name;

    /**
     * Student's surnames
     */
    private String surnames;

    /**
     * Student's birth date
     */
    private LocalDate birthDate;

    /**
     * The course which the student wants to enrol
     */
    private String course;

    /**
     * The month which is going to go the student
     */
    private Month month;

    /**
     * The duration (in weeks) what is going to be the student
     * in the camp
     */
    private int weekDuration;

    /**
     * Constructor full parametrized
     * @param name the name of the student
     * @param surnames the surnames of the student
     * @param birthDate the birth date of the student
     * @param course the course of the student
     * @param month the month which is going to be the student
     * @param weekDuration the time in weeks what the student is going to spent on the camp
     */
    public PendingApp(String name, String surnames, LocalDate birthDate, String course, Month month, int weekDuration) {
        this.name = name;
        this.surnames = surnames;
        this.birthDate = birthDate;
        this.course = course;
        this.month = month;
        this.weekDuration = weekDuration;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCourse() {
        return course;
    }

    public Month getMonth() {
        return month;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public String getLine() {
        return name + ";" + surnames + ";" + birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";" + course + ";" + month.getValue() + ";" + weekDuration;
    }

    @Override
    public String toString() {
        return name + " " + surnames + " " + birthDate + " " + course + " " + month + " " + weekDuration;
    }

}
