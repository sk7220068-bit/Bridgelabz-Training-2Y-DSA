import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.next();

        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught in main: " + e);
        }

        handleException(text);
        scanner.close();
    }

    public static void generateException(String text) {
        System.out.println("Generating StringIndexOutOfBoundsException:");
        System.out.println(text.charAt(text.length()));
    }

    public static void handleException(String text) {
        System.out.println("\nHandling StringIndexOutOfBoundsException:");
        try {
            System.out.println(text.charAt(text.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
