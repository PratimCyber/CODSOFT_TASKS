import java.util.ArrayList;
import java.util.Scanner;

// Course class
class Course {

    String code;
    String title;
    int capacity;
    int registeredStudents;

    Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
        this.registeredStudents = 0;
    }

    // Display course information
    void displayCourse() {
        System.out.println(
            code + " - " + title +
            " | Available Seats: " +
            (capacity - registeredStudents)
        );
    }
}


// Student class
class Student {

    int id;
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Register for a course
    void registerCourse(Course course) {

        if (course.registeredStudents < course.capacity) {

            courses.add(course);
            course.registeredStudents++;

            System.out.println("Course registered successfully.");

        } else {
            System.out.println("Sorry, no seats available.");
        }
    }

    // Remove a course
    void removeCourse(String code) {

        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).code.equals(code)) {

                courses.get(i).registeredStudents--;
                courses.remove(i);

                System.out.println("Course removed successfully.");
                return;
            }
        }

        System.out.println("You are not registered for this course.");
    }

    // Display registered courses
    void showCourses() {

        System.out.println("\n--- REGISTERED COURSES ---");

        if (courses.size() == 0) {
            System.out.println("No courses registered.");
        } else {
            for (Course course : courses) {
                System.out.println(course.code + " - " + course.title);
            }
        }
    }
}


// Main class
public class task_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create courses
        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course("CS101", "Java Programming", 3));
        courses.add(new Course("CS102", "Database Management", 2));
        courses.add(new Course("CS103", "Computer Networks", 3));

        // Create student
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        Student student = new Student(id, name);

        int choice;

        do {

            System.out.println("\n===== COURSE REGISTRATION =====");
            System.out.println("1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Remove Course");
            System.out.println("4. View My Courses");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n--- AVAILABLE COURSES ---");

                    for (Course course : courses) {
                        course.displayCourse();
                    }

                    break;


                case 2:

                    System.out.print("Enter course code: ");
                    String registerCode = sc.next();

                    boolean found = false;

                    for (Course course : courses) {

                        if (course.code.equalsIgnoreCase(registerCode)) {

                            student.registerCourse(course);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Course not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter course code to remove: ");
                    String removeCode = sc.next();
                    student.removeCourse(removeCode);
                    break;
                case 4:
                    student.showCourses();
                    break;
                case 5:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}