import java.util.Scanner;

public class NumberFormatDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to convert to integer:");
        String text = scanner.next();

        try {
            generateException(text);
        } catch (NumberFormatException e) {
            System.out.println("Caught in main: " + e);
        }

        handleException(text);
        scanner.close();
    }

    public static void generateException(String text) {
        System.out.println("Generating NumberFormatException:");
        int number = Integer.parseInt(text);
        System.out.println("Converted number: " + number);
    }

    public static void handleException(String text) {
        System.out.println("\nHandling NumberFormatException:");
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
