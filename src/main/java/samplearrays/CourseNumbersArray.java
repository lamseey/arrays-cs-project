package samplearrays;

public class CourseNumbersArray {
    public static int[] addCourse(int[] courses, int newCourse) {
        int n = courses.length;
        int[] newCourses = new int[n + 1];
        for (int i = 0; i < n; i++) {
            newCourses[i] = courses[i];
        }
        newCourses[n] = newCourse;
        return newCourses;
    }

    public static boolean isRegistered(int[] courses, int courseToCheck) {
        for (int course : courses) {
            if (course == courseToCheck) {
                return true;
            }
        }
        return false;
    }

    public static void printCourses(int[] courses) {
        for (int course : courses) {
            System.out.print(course + ",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = addCourse(registeredCourses, 2000);
        printCourses(updatedCourses);
        System.out.println("Is registered for 2000: " + isRegistered(updatedCourses, 2000)); // true
        System.out.println("Is registered for 3000: " + isRegistered(updatedCourses, 3000)); // false
    }
}
