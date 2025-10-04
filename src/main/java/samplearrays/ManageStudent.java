package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if (students.length == 0) {
            // handle empty array
            System.out.println("No students available.");
            return null;
        }
        Student oldest = students[0]; // assume first is oldest
        for (Student s : students) {
            if (s.getAge() > oldest.getAge()) { // found older
                oldest = s; // update oldest
            }
        }
        return oldest; // return oldest found
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0; // counter for adults
        for (Student s : students) {
            if (s.isAdult()) { // check if adult
                count++; // increment count
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students.length == 0) {
            // handle empty array
            System.out.println("No students available.");
            return Double.NaN;
        }
        int total = 0; // sum of grades
        for (Student s : students) {
            total += s.getGrade(); // accumulate grades
        }
        return (double) total / students.length; // compute average

    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students) {
            if (s.getName().equals(name)) {
                return s; // found
            }
        }
        System.out.println("Student with name " + name + " not found.");
        return null; // not found
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        // Bubble sort
        for (int i = 0; i < students.length - 1; i++){
            for (int j = 0; j < students.length - 1 - i; j++){
                // compare adjacent
                if (students[j].getGrade() < students[j + 1].getGrade()){
                    // swap
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student s : students) {
            if (s.getGrade() >= 15) { // high achiever
                System.out.println(s); // print student
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setGrade(newGrade); // update grade
                return true; // success
            }
        }
        return false; // id not found

    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getName().equals(students[j].getName())) {
                    System.out.println("Duplicates found");
                    return true; // duplicates found
                }
            }
        }
        return false; // no duplicates

    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        int n = students.length; // current number of students
        Student[] updatedStudents = new Student[n + 1]; // new array with one more slot
        for (int i = 0; i < n; i++) {
            updatedStudents[i] = students[i]; // copy existing students
        }
        updatedStudents[n] = newStudent; // add new student at the end

        return updatedStudents; // return new array
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(1, "Ali", 20, 18);
        arr[1] = new Student(2, "Salim", 17, 12);
        arr[2] = new Student(3, "Ahmed", 19, 15);
        arr[3] = new Student(4, "Yassine", 22, 10);
        arr[4] = new Student(5, "Aya", 16, 8);

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldest = findOldest(arr);
        System.out.println("\nOldest student: " + oldest);


        // 3) Count adults
        int adultCount = countAdults(arr);
        System.out.println("\nNumber of adult students: " + adultCount);


        // 4) Average grade
        double avgGrade = averageGrade(arr);
        System.out.printf("\nAverage grade: %.2f\n", avgGrade);


        // 5) Find by name
        Student found = findStudentByName(arr, "Ahmed");
        System.out.println("\nFound by name 'Ahmed': " + found);


        // 6) Sort by grade desc
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        sortByGradeDesc(arr);
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = updateGrade(arr, 4, 16); // update Yassine's grade to 16
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println("After update:");
        for (Student s : arr) System.out.println(s);

        // 9) Duplicate names
        boolean hasDuplicates = hasDuplicateNames(arr);
        System.out.println("\nHas duplicate names? " + hasDuplicates);


        // 10) Append new student
        Student newStudent = new Student(6, "Dina", 18, 14);
        arr = appendStudent(arr, newStudent); // update reference to new array
        System.out.println("\nAfter appending new student:");
        for (Student s : arr) System.out.println(s);

        // 11) Represent a school in 2D array (classes x students)

        Student[][] school = new Student[2][3]; // 2 classes, 3 students each

        // First class
        school[0][0] = new Student(1, "Ali", 20, 18);
        school[0][1] = new Student(2, "Salim", 17, 12);
        school[0][2] = new Student(3, "Ahmed", 19, 15);

        // Second class
        school[1][0] = new Student(4, "Yassine", 22, 10);
        school[1][1] = new Student(5, "Aya", 16, 8);
        school[1][2] = new Student(6, "Dina", 18, 14);

        System.out.println("\n== School Classes ==");
        for (int i = 0; i < school.length; i++) {
            System.out.println("Class " + (i + 1) + ":");
            for (int j = 0; j < school[i].length; j++) {
                System.out.println("  " + school[i][j]);
            }
        }

        // Find the Top Student in each class
        System.out.println("\nTop students in each class:");
        for (int i = 0; i < school.length; i++) {
            Student topStudent = school[i][0];
            for (int j = 1; j < school[i].length; j++) {
                if (school[i][j].getGrade() > topStudent.getGrade()) {
                    topStudent = school[i][j];
                }
            }
            System.out.println("Class " + (i + 1) + " top student: " + topStudent);
        }

    }
}

