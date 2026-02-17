import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicatesStringBuilder {

    public static String removeDuplicates(String text) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String result = removeDuplicates(text);
        System.out.println("String without duplicates: " + result);
        scanner.close();
    }
}
