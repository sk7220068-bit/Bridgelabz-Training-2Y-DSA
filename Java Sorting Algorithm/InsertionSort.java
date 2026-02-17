import java.util.Scanner;

public class InsertionSort {

    public static void insertionSort(int[] ids) {
        int n = ids.length;
        for (int i = 1; i < n; ++i) {
            int key = ids[i];
            int j = i - 1;

            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j = j - 1;
            }
            ids[j + 1] = key;
        }
    }

    public static void printArray(int[] ids) {
        for (int val : ids) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();
        int[] ids = new int[n];

        System.out.println("Enter Employee IDs:");
        for (int i = 0; i < n; i++) {
            ids[i] = scanner.nextInt();
        }

        System.out.println("Original IDs:");
        printArray(ids);

        insertionSort(ids);

        System.out.println("Sorted IDs:");
        printArray(ids);
        scanner.close();
    }
}
