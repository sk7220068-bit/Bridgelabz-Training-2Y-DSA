import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubarrays {
    public static List<int[]> findSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        
        List<Integer> initial = new ArrayList<>();
        initial.add(-1);
        map.put(0, initial);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                List<Integer> indices = map.get(sum);
                for (int index : indices) {
                    result.add(new int[]{index + 1, i});
                }
            } else {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<int[]> subarrays = findSubarrays(arr);
        for (int[] sub : subarrays) {
            System.out.println("Subarray found from index " + sub[0] + " to " + sub[1]);
        }
    }
}
