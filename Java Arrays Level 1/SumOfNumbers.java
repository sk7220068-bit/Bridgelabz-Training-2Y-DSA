import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        // Create an array to store up to 10 double values
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers (enter 0 or a negative number to stop, max 10 numbers):");

        // Infinite loop to take input
        while (true) {
            // Check if array is full
            if (index == 10) {
                System.out.println("Maximum limit of 10 numbers reached.");
                break;
            }

            System.out.print("Enter number: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            double input = scanner.nextDouble();

            // Check condition to break the loop (0 or negative number)
            if (input <= 0) {
                break;
            }

            // Store value and increment index
            numbers[index] = input;
            index++;
        }

        // Display numbers and calculate total
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("Sum of all numbers: " + total);

        scanner.close();
    }
}
