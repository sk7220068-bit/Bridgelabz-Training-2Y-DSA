import java.util.Scanner;

public class FootballTeamMeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a double array named heights of size 11
        double[] heights = new double[11];
        double sum = 0.0;

        System.out.println("Enter the heights of the 11 football players:");

        // Get input values from the user and calculate the sum
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height for player " + (i + 1) + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }

        // Calculate the mean height
        double mean = sum / heights.length;

        // Print the mean height
        System.out.println("The mean height of the football team is: " + mean);

        scanner.close();
    }
}
