import java.util.HashSet;
import java.util.Set;

public class PairSumCheck {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (set.contains(target - x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 16;
        System.out.println("Pair exists: " + hasPairWithSum(arr, target));
    }
}
