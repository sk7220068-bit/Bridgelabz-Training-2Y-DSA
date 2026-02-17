import java.util.Scanner;

public class NumberAnalyzer {
    public static void main(String[] args) {
        // Define an integer array of 5 elements
        int[] numbers = new int[5];
        Scanner scanner = new Scanner(System.in);

        // Get user input to store in the array
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
            numbers[i] = scanner.nextInt();
        }

        // Loop through the array using the length
        System.out.println("\nAnalyzing numbers:");
        for (int number : numbers) {
            if (number < 0) {
                System.out.println(number + " is negative.");
            } else if (number == 0) {
                System.out.println(number + " is zero.");
            } else { // Positive
                if (number % 2 == 0) {
                    System.out.println(number + " is positive and even.");
                } else {
                    System.out.println(number + " is positive and odd.");
                }
            }
        }

        // Compare the first and last element of the array
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        System.out.println("\nComparing first (" + first + ") and last (" + last + ") elements:");
        if (first == last) {
            System.out.println("The first and last elements are equal.");
        } else if (first > last) {
            System.out.println("The first element is greater than the last element.");
        } else {
            System.out.println("The first element is less than the last element.");
        }

        scanner.close();
    }
}
