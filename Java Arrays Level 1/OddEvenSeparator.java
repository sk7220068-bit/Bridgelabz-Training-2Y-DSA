import java.util.Scanner;

public class OddEvenSeparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
        }
        int number = scanner.nextInt();

        // Check for Natural Number
        if (number <= 0) {
            System.out.println("Error: Not a natural number.");
            scanner.close();
            return;
        }

        // Create integer arrays for even and odd numbers
        int[] oddNumbers = new int[number / 2 + 1];
        int[] evenNumbers = new int[number / 2 + 1];

        int oddIndex = 0;
        int evenIndex = 0;

        // Iterate from 1 to the number
        for (int i = 1; i <= number; i++) {
            if (i % 2 != 0) {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            } else {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            }
        }

        // Print the odd numbers array
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();

        // Print the even numbers array
        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
