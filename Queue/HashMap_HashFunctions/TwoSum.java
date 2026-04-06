package HashMap_HashFunctions;

import java.util.*;

public class TwoSum {
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] res = twoSum(nums, 18);
        System.out.println(res[0] + " " + res[1]);
    }
}