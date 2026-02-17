import java.util.Scanner;

public class LowerCaseConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine();

        String customLower = convertToLowerCase(text);
        String builtinLower = text.toLowerCase();

        System.out.println("Custom LowerCase: " + customLower);
        System.out.println("Built-in LowerCase: " + builtinLower);

        if (compareStrings(customLower, builtinLower)) {
            System.out.println("Both conversions are equal.");
        } else {
            System.out.println("Conversions differ.");
        }
        scanner.close();
    }

    public static String convertToLowerCase(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
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
