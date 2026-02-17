import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get an integer input from the user
        System.out.print("Enter a number to find its multiplication table: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
        }
        int number = scanner.nextInt();

        // Define an integer array to store the results of multiplication
        int[] multiplicationResult = new int[10];

        // Run a loop from 1 to 10 and store the results in the array
        for (int i = 1; i <= 10; i++) {
            multiplicationResult[i - 1] = number * i;
        }

        // Display the result from the array in the format number * i = result
        System.out.println("Multiplication Table of " + number);
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 1]);
        }

        scanner.close();
    }
}
