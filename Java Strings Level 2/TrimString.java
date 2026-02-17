import java.util.Scanner;

public class TrimString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string (with spaces):");
        String text = scanner.nextLine();

        int[] trimIndices = findTrimIndices(text);
        String customTrimmed = createSubstring(text, trimIndices[0], trimIndices[1]);
        String builtinTrimmed = text.trim();

        System.out.println("Custom Trimmed: '" + customTrimmed + "'");
        System.out.println("Built-in Trimmed: '" + builtinTrimmed + "'");

        if (compareStrings(customTrimmed, builtinTrimmed)) {
            System.out.println("Both strings are equal.");
        } else {
            System.out.println("Strings differ.");
        }
        scanner.close();
    }

    public static int[] findTrimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < text.length() && text.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[] { start, end + 1 };
    }

    public static String createSubstring(String text, int start, int end) {
        String sub = "";
        for (int i = start; i < end; i++) {
            sub += text.charAt(i);
        }
        return sub;
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
