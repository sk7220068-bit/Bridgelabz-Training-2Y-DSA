import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = scanner.nextInt();
        String[] names = new String[n];

        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            names[i] = scanner.next();
        }

        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught in main: " + e);
        }

        handleException(names);
        scanner.close();
    }

    public static void generateException(String[] names) {
        System.out.println("Generating ArrayIndexOutOfBoundsException:");
        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names) {
        System.out.println("\nHandling ArrayIndexOutOfBoundsException:");
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
