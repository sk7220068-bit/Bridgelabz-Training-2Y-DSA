import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindromeLogic1(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeLogic2(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeLogic2(text, start + 1, end - 1);
    }

    public static boolean isPalindromeLogic3(String text) {
        char[] charArray = text.toCharArray();
        char[] reverseArray = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            reverseArray[i] = charArray[charArray.length - 1 - i];
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != reverseArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        System.out.println("Logic 1 (Iterative): " + isPalindromeLogic1(text));
        System.out.println("Logic 2 (Recursive): " + isPalindromeLogic2(text, 0, text.length() - 1));
        System.out.println("Logic 3 (Array): " + isPalindromeLogic3(text));

        scanner.close();
    }
}
