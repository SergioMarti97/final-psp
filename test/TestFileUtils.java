import summercampfx.model.Course;
import summercampfx.model.PendingApp;
import summercampfx.utils.FileUtils;

public class TestFileUtils {

    public static void main(String[] args) {

        System.out.println("Pending apps:");

        for ( PendingApp app : FileUtils.loadApps() ) {
            System.out.println(app);
        }

        System.out.println("Courses:");

        for ( Course course : FileUtils.loadCourses() ) {
            System.out.println(course);
        }

    }

}
