import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = { "Amar", "Akbar", "Anthony" };
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for " + names[i] + ":");
            System.out.print("Enter age: ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height: ");
            heights[i] = scanner.nextDouble();
        }

        int minAge = ages[0];
        int youngestIndex = 0;
        double maxHeight = heights[0];
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngestIndex = i;
            }
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallestIndex = i;
            }
        }

        System.out.println("Youngest friend is: " + names[youngestIndex] + " (Age: " + minAge + ")");
        System.out.println("Tallest friend is: " + names[tallestIndex] + " (Height: " + maxHeight + ")");

        scanner.close();
    }
}
