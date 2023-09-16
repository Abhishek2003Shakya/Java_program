import java.util.*;

public class number_game {
    public static void main(String[] args) {
        // Clear the console screen using ANSI escape codes
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts;
        int score = 0;
        
        System.out.println("==========================|| Welcome to the Number Guessing Game ||==========================");
        
        do {
            System.out.print("\nEnter the number of attempts for this round: ");
            maxAttempts = scanner.nextInt();
            scanner.nextLine();  //new line character input
            
            // Using try catch for delay the process of thinking
            try {
                System.out.println("\nOk! Let me think a number...");
                Thread.sleep(2000); // Sleep for 1 second
            } catch (InterruptedException e) {
                // Handle the InterruptedException (print an error message)
                e.printStackTrace();
            }
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean Guessed_is_correct = false;
            
            System.out.println("Done... Now it's your turn. Read my mind which number i had guessed just now: ");
            System.out.println("Hint: My number lies between " + minRange + " and " + maxRange + ". Start guessing!");
            
            while (attempts < maxAttempts) {
                System.out.print("\nGuess #" + (attempts + 1) + ": ");
                int userGuess = scanner.nextInt();
                scanner.nextLine();  //new line character input
                
                if (userGuess == targetNumber) {
                    System.out.println("\nCool champ! You guessed the correct number: " + targetNumber);
                    Guessed_is_correct= true;
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("No dude! Your guess is too low.");
                } else {
                    System.out.println("No dude! Your guess is too high.");
                }
                
                attempts++;
            }
            
            if (!Guessed_is_correct) {
                System.out.println("\nSorry dude, try luck your next time. Dude the correct number was: " + targetNumber);
            }
            System.out.println("\n____________________________________________________________________________________________");
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thank you for playing! Your total score is: " + score);
                break;
            }

            // Clear the console screen using ANSI escape codes
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
        } while (true);
        
        scanner.close();
    }
}
