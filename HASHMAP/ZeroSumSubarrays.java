package HASHMAP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubarrays {
    public static void findAllSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        insert(map, 0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                for (Integer index : list) {
                    System.out.println("Subarray [" + (index + 1) + ".." + i + "]");
                }
            }
            insert(map, sum, i);
        }
    }

    private static void insert(Map<Integer, List<Integer>> map, int key, int value) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        findAllSubarrays(arr);
    }
}
