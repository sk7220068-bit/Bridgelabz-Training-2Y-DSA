import java.util.Scanner;

public class CharacterType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.next();

        String[][] charTypes = identifyCharacterTypes(text);
        displayCharacterTypes(charTypes);

        scanner.close();
    }

    public static String checkCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static String[][] identifyCharacterTypes(String text) {
        String[][] results = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            results[i][0] = String.valueOf(ch);
            results[i][1] = checkCharacterType(ch);
        }
        return results;
    }

    public static void displayCharacterTypes(String[][] charTypes) {
        System.out.println("Character\tType");
        System.out.println("---------\t----");
        for (int i = 0; i < charTypes.length; i++) {
            System.out.println(charTypes[i][0] + "\t\t" + charTypes[i][1]);
        }
    }
}
