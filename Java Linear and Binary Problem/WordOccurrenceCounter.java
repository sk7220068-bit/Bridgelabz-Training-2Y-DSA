import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordOccurrenceCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word to search: ");
        String targetWord = scanner.nextLine();
        String filePath = "input.txt";
        int count = 0;

        try (FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            System.out.println("The word '" + targetWord + "' appears " + count + " times.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
