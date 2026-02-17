import java.util.Scanner;

public class QuickSort {

    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }

    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    public static void printArray(double[] prices) {
        for (double val : prices) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = scanner.nextInt();
        double[] prices = new double[n];

        System.out.println("Enter product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }

        System.out.println("Original Prices:");
        printArray(prices);

        quickSort(prices, 0, n - 1);

        System.out.println("Sorted Prices:");
        printArray(prices);
        scanner.close();
    }
}
