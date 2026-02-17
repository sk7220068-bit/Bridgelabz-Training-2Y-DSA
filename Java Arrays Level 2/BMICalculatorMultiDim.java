import java.util.Scanner;

public class BMICalculatorMultiDim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();

        // 0: Weight, 1: Height, 2: BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            double weight = scanner.nextDouble();
            System.out.print("Height (m): ");
            double height = scanner.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input. Height and weight must be positive.");
                i--;
                continue;
            }

            personData[i][0] = weight;
            personData[i][1] = height;

            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nBMI Report:");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ": Height=" + personData[i][1] + "m, Weight=" + personData[i][0]
                    + "kg, BMI=" + personData[i][2] + ", Status=" + weightStatus[i]);
        }

        scanner.close();
    }
}
