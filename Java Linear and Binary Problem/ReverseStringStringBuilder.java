import java.util.Scanner;

public class ReverseStringStringBuilder {

    public static String reverseString(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String reversed = reverseString(text);
        System.out.println("Reversed string: " + reversed);
        scanner.close();
    }
}
