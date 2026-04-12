package HASHMAP;

import java.util.HashSet;
import java.util.Set;

public class PairWithSum {
    public static boolean hasPair(int[] arr, int target) {
        Set<Integer> visited = new HashSet<>();
        for (int x : arr) {
            if (visited.contains(target - x)) {
                return true;
            }
            visited.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 7, 2, 5, 3, 1 };
        int target = 10;
        System.out.println(hasPair(arr, target));
    }
}
