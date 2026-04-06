package HashMap_HashFunctions;

import java.util.*;

public class ZeroSumSubarrays {
    static int countSubarrays(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0, 1);

        for (int x : arr) {
            sum += x;
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 0};
        System.out.println(countSubarrays(arr));
    }
}