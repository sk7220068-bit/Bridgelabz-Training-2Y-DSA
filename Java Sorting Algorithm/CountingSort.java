import java.util.Scanner;
import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] ages) {
        int n = ages.length;
        if (n == 0)
            return;

        int max = Arrays.stream(ages).max().getAsInt();
        int min = Arrays.stream(ages).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[ages[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }
    }

    public static void printArray(int[] ages) {
        for (int val : ages) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] ages = new int[n];

        System.out.println("Enter ages (10-18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }

        System.out.println("Original Ages:");
        printArray(ages);

        countingSort(ages);

        System.out.println("Sorted Ages:");
        printArray(ages);
        scanner.close();
    }
}
