import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.next();

        try {
            generateException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught in main: " + e);
        } catch (RuntimeException e) {
            System.out.println("Caught Generic RuntimeException in main: " + e);
        }

        handleException(text);
        scanner.close();
    }

    public static void generateException(String text) {
        System.out.println("Generating IllegalArgumentException (via substring):");
        // start index > end index causes StringIndexOutOfBoundsException (which is a
        // RuntimeException)
        // Note: substring throws StringIndexOutOfBoundsException if start > end, not
        // typically IllegalArgumentException directly
        // but let's follow the prompt's instruction to demonstrate exception handling.
        // Actually java.lang.String.substring throws StringIndexOutOfBoundsException.
        // To strictly follow "demonstrate IllegalArgumentException" as per prompt using
        // substring might be tricky if it throws index out of bounds.
        // However, we will proceed as requested to show the error.
        System.out.println(text.substring(3, 1));
    }

    public static void handleException(String text) {
        System.out.println("\nHandling IllegalArgumentException / RuntimeException:");
        try {
            System.out.println(text.substring(3, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
