import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeating(String text) {
        int[] frequency = new int[256];
        int len = text.length();

        for (int i = 0; i < len; i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < len; i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeating(text);
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
        scanner.close();
    }
}
