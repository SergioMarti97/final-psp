package summercampfx.utils;

import summercampfx.model.Course;
import summercampfx.model.PendingApp;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is needed for save and write the information
 * inside the text files
 *
 * @class FileUtils
 * @author Sergio Martí Torregrosa
 * @date 26/10/2020
 */
public class FileUtils {

    /**
     * This method loads the applications for the summer courses from a given text file
     * @return the applications for the courses
     */
    public static List<PendingApp> loadApps() {
        ArrayList<PendingApp> pendingApps = new ArrayList<>();
        try {
            FileReader fr = new FileReader(System.getProperty("user.dir") + File.separator + "pendingApps.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while ( line != null ) {

                String[] info = line.split(";");
                String[] date = info[2].split("/");

                if (info.length == 6) {
                    pendingApps.add(
                            new PendingApp(
                                    info[0],
                                    info[1],
                                    LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0])),
                                    info[3],
                                    Month.values()[Integer.parseInt(info[4])-1],
                                    Integer.parseInt(info[5])
                            )
                    );
                }

                line = br.readLine();

            }

        } catch ( FileNotFoundException e ) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pendingApps;
    }

    /**
     * This method loads the courses from a text file
     * @return the courses of the summer camp
     */
    public static List<Course> loadCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            FileReader fr = new FileReader(System.getProperty("user.dir") + File.separator + "courses.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while ( line != null ) {

                String[] info = line.split(";");

                if (info.length == 3) {
                    courses.add(
                            new Course(
                                    info[0],
                                    Integer.parseInt(info[1]),
                                    Integer.parseInt(info[2])
                            )
                    );
                }

                line = br.readLine();

            }

        } catch ( FileNotFoundException e ) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * This method saves the pending applications not processed again in the text file
     * before exiting the program
     */
    public static void saveApps() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + File.separator + "courses.txt"));
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    /**
     * This method saves a new application created in our program
     * @param line the information of the new application
     */
    public static void saveApp(String line) throws IOException {
        String fileName = System.getProperty("user.dir") + File.separator + "pendingApps.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        bw.newLine();
        bw.write(line);
        bw.close();
    }

    /**
     * This method saves a new course created
     * @param line the information of the new application
     */
    public static void saveCourse(String line) throws IOException {
        String fileName = System.getProperty("user.dir") + File.separator + "courses.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        bw.newLine();
        bw.write(line);
        bw.close();
    }

    /**
     * This method saves the students assigned to a cabin in the file
     * "./cabins/" + situation + ".txt"
     * @param situation the situation of the cabin
     */
    public static void saveCabin(String situation) {

    }

}
