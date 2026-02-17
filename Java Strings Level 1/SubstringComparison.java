import java.util.Scanner;

public class SubstringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.next();
        System.out.println("Enter start index:");
        int start = scanner.nextInt();
        System.out.println("Enter end index:");
        int end = scanner.nextInt();

        String customSubstring = createSubstring(text, start, end);
        String builtinSubstring = text.substring(start, end);

        System.out.println("Custom substring: " + customSubstring);
        System.out.println("Built-in substring: " + builtinSubstring);

        if (customSubstring.equals(builtinSubstring)) {
            System.out.println("Both substrings are equal.");
        } else {
            System.out.println("Substrings are different.");
        }
        scanner.close();
    }

    public static String createSubstring(String text, int start, int end) {
        String sub = "";
        for (int i = start; i < end; i++) {
            sub += text.charAt(i);
        }
        return sub;
    }
}
