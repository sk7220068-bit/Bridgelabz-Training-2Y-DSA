import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int findLongest(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);
        
        int maxLen = 0;
        for (int x : arr) {
            if (!set.contains(x - 1)) {
                int curr = x;
                int len = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive length: " + findLongest(arr));
    }
}
