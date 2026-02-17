import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = scanner.nextInt();

        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmis = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            weights[i] = scanner.nextDouble();
            System.out.print("Height (m): ");
            heights[i] = scanner.nextDouble();

            if (weights[i] <= 0 || heights[i] <= 0) {
                System.out.println("Invalid input. Height and weight must be positive.");
                i--;
                continue;
            }

            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmis[i] < 24.9) {
                status[i] = "Normal weight";
            } else if (bmis[i] < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        System.out.println("\nBMI Report:");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ": Height=" + heights[i] + "m, Weight=" + weights[i] + "kg, BMI="
                    + bmis[i] + ", Status=" + status[i]);
        }

        scanner.close();
    }
}
