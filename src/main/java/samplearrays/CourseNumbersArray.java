package samplearrays;

public class CourseNumbersArray {
    public static int[] addCourse(int[] courses, int newCourse) {
        int n = courses.length; // current number of courses
        int[] newCourses = new int[n + 1]; // create new array with one more slot
        for (int i = 0; i < n; i++) {
            newCourses[i] = courses[i];  // copy existing courses
        }
        newCourses[n] = newCourse; // add the new course at the end
        return newCourses; // return the new array
    }

    public static boolean isRegistered(int[] courses, int courseToCheck) {
        for (int course : courses) {
            if (course == courseToCheck) { // found
                return true; // return immediately
            }
        }
        // not found
        return false;
    }

    public static void printCourses(int[] courses) {
        for (int course : courses) {
            System.out.print(course + ","); // print each course followed by a comma
        }
        System.out.println(); // new line after printing all courses
    }


    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160}; // initial courses
        int[] updatedCourses = addCourse(registeredCourses, 2000); // add course 2000
        printCourses(updatedCourses); // print all courses
        System.out.println("Is registered for 2000: " + isRegistered(updatedCourses, 2000)); // true
        System.out.println("Is registered for 3000: " + isRegistered(updatedCourses, 3000)); // false
    }
}
