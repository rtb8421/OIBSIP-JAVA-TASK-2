/*Oasis infobyte
java programming Task 2
Number Guessing game*/



import java.util.Random;
import java.util.Scanner;                      
public class Task2 {                         
    public static final int MAX_ATTEMPTS = 10;
    public static final int MAX_ROUNDS = 2;

    public int targetNumber;
    public int currentRound;
    public int totalScore;

    public Task2() {
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        currentRound = 1;
        totalScore = 0;
    }

    public void playGame() {
        while (currentRound <= MAX_ROUNDS) {
            System.out.println("Number Guessing Game");
            System.out.println("Round " + currentRound);
            System.out.println("Guess a number between 1 and 100.");

            int attempts = 0;
            int guess;
            boolean isCorrect = false;

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                guess = getUserGuess();
                if (guess == targetNumber) {
                    isCorrect = true;
                    int roundScore = MAX_ATTEMPTS - attempts;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low");
                } else {
                    System.out.println("Too high!");
                }

                attempts++;
            }

            if (!isCorrect) {
                System.out.println("You failed to guess the number. The correct number was: " + targetNumber);
            }

            currentRound++;

            if (currentRound <= MAX_ROUNDS) {
                System.out.println("Round over. Starting the next round.");
                resetTargetNumber();
            } else {
                System.out.println("Game over. Total Score: " + totalScore);
            }
        }
    }
    public int getUserGuess(){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input");
            scanner.next();
            scanner.close();
        }
        return scanner.nextInt();
    }

    public void resetTargetNumber() {
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
    }

    public static void main(String[] args) {
        Task2 game = new Task2();
        game.playGame();
}
}
