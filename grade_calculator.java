import java.util.*;

public class grade_calculator {
    public static void main(String[] args) {
        // Clear the console screen using ANSI escape codes
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================|| STUDENT GRADE CALCULATOR ||========================");

        // Make a grade system ranges
        final int A_plus = 90;
        final int A = 80;
        final int B_plus = 70;
        final int B = 60;
        final int C = 50;
        final int FAIL = 0;

        // Initialize variables
        int totalMarks = 0;
        int numberOfSubjects;

        // Input: Take the number of subjects
        System.out.print("\n");
        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = scanner.nextInt();

        // Take marks for each subject and calculate total marks
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            int subjectMarks = scanner.nextInt();
            totalMarks += subjectMarks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Grade calculation based on average percentage
        String grade;
        if (averagePercentage >= A_plus) {
            grade = "A+";
        } else if (averagePercentage >= A) {
            grade = "A";
        } else if (averagePercentage >= B_plus) {
            grade = "B+";
        } else if (averagePercentage >= B) {
            grade = "B";
        } else if (averagePercentage >= C) {
            grade = "C";
        } else {
            grade = "FAIL";
        }

        // Display results
        System.out.println("\n------------------------------ RESULT ------------------------------");
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        // just for fun
        if (averagePercentage >= A_plus) {
            System.out.println("\nTopper ji.");
        }
        else if (averagePercentage >= B_plus) {
            System.out.println("\nGood luck for bright future.");
        }
        else if (averagePercentage >= B || averagePercentage >= C) {
            System.out.println("\nYou are an average try to improve!");
        }
        else {
            System.out.println("\nDon't sad buddy! Even the best person fall down sometimes.");
        }
        
        scanner.close();
    }
}
