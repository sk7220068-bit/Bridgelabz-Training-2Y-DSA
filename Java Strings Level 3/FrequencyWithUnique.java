import java.util.Scanner;

public class FrequencyWithUnique {

    public static char[] findUnique(String text) {
        int length = text.length();
        char[] uniqueChars = new char[length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            boolean found = false;
            for (int j = 0; j < count; j++) {
                if (text.charAt(i) == uniqueChars[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                uniqueChars[count++] = text.charAt(i);
            }
        }

        char[] result = new char[count];
        System.arraycopy(uniqueChars, 0, result, 0, count);
        return result;
    }

    public static String[][] findFrequency(String text) {
        char[] uniqueChars = findUnique(text);
        String[][] result = new String[uniqueChars.length][2];
        int length = text.length();

        for (int i = 0; i < uniqueChars.length; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (text.charAt(j) == uniqueChars[i]) {
                    count++;
                }
            }
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String[][] result = findFrequency(text);
        System.out.println("Character\tFrequency");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }
        scanner.close();
    }
}
