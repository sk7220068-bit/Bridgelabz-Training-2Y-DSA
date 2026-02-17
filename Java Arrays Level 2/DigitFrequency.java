import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        int[] frequency = new int[10];

        long tempNumber = Math.abs(number);
        if (tempNumber == 0) {
            frequency[0]++;
        } else {
            while (tempNumber > 0) {
                int digit = (int) (tempNumber % 10);
                frequency[digit]++;
                tempNumber /= 10;
            }
        }

        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " times");
            }
        }

        scanner.close();
    }
}
