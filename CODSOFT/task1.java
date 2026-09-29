import java.util.Random;
import java.util.Scanner;
public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        char playAgain;
        do {
            int number = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;
            System.out.println("\n--- NUMBER GUESSING GAME ---");
            System.out.println("Guess a number between 1 and 100");
            while (guess != number) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;
                if (guess < number) {
                    System.out.println("Too Low! \nTry again.");
                }
                else if (guess > number) {
                    System.out.println("Too High! Try again.");
                }
                else {
                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Attempts: " + attempts);
                    score += 100 - attempts;
                }
            }
            System.out.println("Your Score: " + score);
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);
        } while (playAgain == 'y' || playAgain == 'Y');
        System.out.println("\nGame Over!");
        System.out.println("Final Score: " + score);
        sc.close();
    }
}