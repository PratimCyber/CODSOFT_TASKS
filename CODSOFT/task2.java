import java.util.Scanner;

public class task_2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subjects;
        int total = 0;
        System.out.print("Enter number of subjects: ");
        subjects = sc.nextInt();
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();
            total = total + marks;
        }
        float percentage = (float) total / subjects;
        char grade;
        if (percentage >= 90) {
            grade = 'A';
        }
        else if (percentage >= 80) {
            grade = 'B';
        }
        else if (percentage >= 70) {
            grade = 'C';
        }
        else if (percentage >= 60) {
            grade = 'D';
        }
        else if (percentage >= 50) {
            grade = 'E';
        }
        else {
            grade = 'F';
        }
        System.out.println("\n--- STUDENT RESULT ---");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        sc.close();
    }
}