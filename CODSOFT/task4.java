import java.util.Scanner;
import java.util.concurrent.*;
public class task_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] questions = {
            "Which language is used for Android development?",
            "What is the size of an int in Java?",
            "Which keyword is used to create a class?"
        };
        String[][] options = {
            {"1. Java", "2. HTML", "3. CSS", "4. SQL"},
            {"1. 2 bytes", "2. 4 bytes", "3. 8 bytes", "4. 1 byte"},
            {"1. new", "2. class", "3. create", "4. object"}
        };
        int[] correctAnswers = {1, 2, 2};
        int score = 0;
        int timeLimit = 10; // 10 seconds for each question
        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("===== QUIZ APPLICATION =====");
        System.out.println("You have " + timeLimit + " seconds for each question.\n");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Enter your answer: ");
            Future<String> answer = executor.submit(() -> sc.nextLine());
            try {
                String input = answer.get(timeLimit, TimeUnit.SECONDS);
                int userAnswer = Integer.parseInt(input);
                if (userAnswer == correctAnswers[i]) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong answer!\n");
                }
            } catch (TimeoutException e) {
                System.out.println("\nTime's up!\n");
                answer.cancel(true);
            } catch (Exception e) {
                System.out.println("Invalid answer!\n");
            }
        }
        executor.shutdownNow();
        System.out.println("===== QUIZ RESULT =====");
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.length - score));
        System.out.println("Final Score: " + score + "/" + questions.length);
        sc.close();
    }
}