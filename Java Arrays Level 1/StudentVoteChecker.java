import java.util.Scanner;

public class StudentVoteChecker {
    public static void main(String[] args) {
        // Define an array of 10 integer elements
        int[] ages = new int[10];
        Scanner scanner = new Scanner(System.in);

        // Take user input for the student's age
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            // Validate input to ensure it is an integer
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // consume the invalid input
            }
            ages[i] = scanner.nextInt();
        }

        // Loop through the array using the length property
        System.out.println("\nChecking voting eligibility:");
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            
            // Check eligibility logic as per requirements
            if (age < 0) {
                System.out.println("Invalid age: " + age);
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }
        
        scanner.close();
    }
}
