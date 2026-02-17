import java.util.Scanner;

public class SplitTextWithLengths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text:");
        String text = scanner.nextLine();

        String[] words = splitText(text);
        String[][] wordsWithLengths = getWordsWithLengths(words);

        System.out.println("\nWords and their Lengths:");
        System.out.println("Word\t\tLength");
        System.out.println("----\t\t------");

        for (int i = 0; i < wordsWithLengths.length; i++) {
            System.out.printf("%-15s %d\n", wordsWithLengths[i][0], Integer.parseInt(wordsWithLengths[i][1]));
        }
        scanner.close();
    }

    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] splitText(String text) {
        int len = getStringLength(text);
        int wordCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        wordCount++;

        String[] words = new String[wordCount];
        int wordIndex = 0;
        int startIndex = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex] = "";
                for (int j = startIndex; j < i; j++) {
                    words[wordIndex] += text.charAt(j);
                }
                wordIndex++;
                startIndex = i + 1;
            }
        }

        words[wordIndex] = "";
        for (int j = startIndex; j < len; j++) {
            words[wordIndex] += text.charAt(j);
        }

        return words;
    }

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return result;
    }
}
