import java.util.Scanner;
import java.util.Arrays;

public class CharacterArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.next();

        char[] customArray = getCharArray(text);
        char[] builtinArray = text.toCharArray();

        boolean areEqual = compareArrays(customArray, builtinArray);

        System.out.println("Custom char array: " + Arrays.toString(customArray));
        System.out.println("Built-in char array: " + Arrays.toString(builtinArray));
        System.out.println("Are both arrays equal? " + areEqual);

        scanner.close();
    }

    public static char[] getCharArray(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
