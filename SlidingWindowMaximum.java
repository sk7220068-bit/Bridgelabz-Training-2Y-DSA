import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

public class SlidingWindowMaximum {
    public static int[] findMax(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) return new int[0];
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = arr[dq.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = findMax(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
