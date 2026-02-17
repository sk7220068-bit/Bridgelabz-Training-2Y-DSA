import java.util.Scanner;
import java.util.Random;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Generating ages for 10 students...");

        int[] ages = generateAges(10);
        String[][] results = checkEligibility(ages);
        displayVotingStatus(results);

        scanner.close();
    }

    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + random.nextInt(90);
        }
        return ages;
    }

    public static String[][] checkEligibility(int[] ages) {
        String[][] results = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            results[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                results[i][1] = "false";
            } else if (ages[i] >= 18) {
                results[i][1] = "true";
            } else {
                results[i][1] = "false";
            }
        }
        return results;
    }

    public static void displayVotingStatus(String[][] results) {
        System.out.println("Age\tCan Vote");
        System.out.println("---\t--------");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i][0] + "\t" + results[i][1]);
        }
    }
}
