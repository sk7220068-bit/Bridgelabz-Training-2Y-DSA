import java.util.Scanner;

public class UpperCaseConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine();

        String customUpper = convertToUpperCase(text);
        String builtinUpper = text.toUpperCase();

        System.out.println("Custom UpperCase: " + customUpper);
        System.out.println("Built-in UpperCase: " + builtinUpper);

        if (compareStrings(customUpper, builtinUpper)) {
            System.out.println("Both conversions are equal.");
        } else {
            System.out.println("Conversions differ.");
        }
        scanner.close();
    }

    public static String convertToUpperCase(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            }
        }
        return new String(chars);
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
