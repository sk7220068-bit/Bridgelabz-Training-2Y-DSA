import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number == 0) {
            System.out.println("Reversed number: 0");
            scanner.close();
            return;
        }

        int tempNumber = Math.abs(number);
        int digitCount = (int) Math.log10(tempNumber) + 1;
        int[] digits = new int[digitCount];

        for (int i = 0; i < digitCount; i++) {
            digits[i] = tempNumber % 10;
            tempNumber /= 10;
        }

        System.out.print("Reversed number: ");
        if (number < 0)
            System.out.print("-");

        for (int i = 0; i < digitCount; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();

        scanner.close();
    }
}
