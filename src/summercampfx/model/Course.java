package summercampfx.model;

import summercampfx.utils.Month;

/**
 * This class is for the Course of the summer camp
 *
 * @class Course
 * @author Sergio Martí Torregrosa
 * @date 26/10/2020
 */
public class Course {

    /**
     * The name of the course
     */
    private String name;

    /**
     * The month of the course
     */
    private int month;

    /**
     * The duration in weeks of the course
     */
    private int weeksDuration;

    /**
     * Constructor full parametrized
     * @param name the name of the course
     * @param month the month of the course
     * @param weeksDuration the duration of the course in weeks
     */
    public Course(String name, int month, int weeksDuration) {
        this.name = name;
        this.month = month;
        this.weeksDuration = weeksDuration;
    }

    public String getName() {
        return name;
    }

    public int getMonth() {
        return month;
    }

    public int getWeeksDuration() {
        return weeksDuration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setWeeksDuration(int weeksDuration) {
        this.weeksDuration = weeksDuration;
    }

    public String getLine() {
        return name + ';' + month + ';' + weeksDuration;
    }

    @Override
    public String toString() {
        return name + " " + Month.values()[month-1] + " Duration: " + weeksDuration + " weeks";
    }

}
