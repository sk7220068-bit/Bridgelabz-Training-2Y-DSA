import java.util.Scanner;

public class ShortestLongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text:");
        String text = scanner.nextLine();

        String[] words = splitText(text);
        if (words.length == 0) {
            System.out.println("No words found.");
            scanner.close();
            return;
        }

        String[][] wordsWithLengths = getWordsWithLengths(words);
        int[] indices = findShortestLongest(wordsWithLengths);

        System.out.println("Shortest word: " + wordsWithLengths[indices[0]][0] + " (Length: "
                + wordsWithLengths[indices[0]][1] + ")");
        System.out.println("Longest word: " + wordsWithLengths[indices[1]][0] + " (Length: "
                + wordsWithLengths[indices[1]][1] + ")");

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
        if (len == 0)
            return new String[0];

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

    public static int[] findShortestLongest(String[][] wordsWithLengths) {
        int minIndex = 0;
        int maxIndex = 0;
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < wordsWithLengths.length; i++) {
            int len = Integer.parseInt(wordsWithLengths[i][1]);
            if (len < minLen) {
                minLen = len;
                minIndex = i;
            }
            if (len > maxLen) {
                maxLen = len;
                maxIndex = i;
            }
        }
        return new int[] { minIndex, maxIndex };
    }
}
