import java.util.Scanner;

public class SelectionSort {

    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = scores[min_idx];
            scores[min_idx] = scores[i];
            scores[i] = temp;
        }
    }

    public static void printArray(int[] scores) {
        for (int val : scores) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] scores = new int[n];

        System.out.println("Enter exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        System.out.println("Original Scores:");
        printArray(scores);

        selectionSort(scores);

        System.out.println("Sorted Scores:");
        printArray(scores);
        scanner.close();
    }
}
