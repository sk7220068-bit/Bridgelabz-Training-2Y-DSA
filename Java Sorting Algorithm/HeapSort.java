import java.util.Scanner;

public class HeapSort {

    public static void sort(double[] salary) {
        int n = salary.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(salary, n, i);

        for (int i = n - 1; i > 0; i--) {
            double temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;

            heapify(salary, i, 0);
        }
    }

    public static void heapify(double[] salary, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && salary[l] > salary[largest])
            largest = l;

        if (r < n && salary[r] > salary[largest])
            largest = r;

        if (largest != i) {
            double swap = salary[i];
            salary[i] = salary[largest];
            salary[largest] = swap;

            heapify(salary, n, largest);
        }
    }

    public static void printArray(double[] salary) {
        for (double val : salary) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of applicants: ");
        int n = scanner.nextInt();
        double[] salary = new double[n];

        System.out.println("Enter salaries:");
        for (int i = 0; i < n; i++) {
            salary[i] = scanner.nextDouble();
        }

        System.out.println("Original Salaries:");
        printArray(salary);

        sort(salary);

        System.out.println("Sorted Salaries:");
        printArray(salary);
        scanner.close();
    }
}
