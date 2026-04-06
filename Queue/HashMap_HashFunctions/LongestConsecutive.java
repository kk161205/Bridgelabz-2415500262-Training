package HashMap_HashFunctions;

import java.util.*;

public class LongestConsecutive {
    static int longest(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int max = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int curr = x;
                int count = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longest(nums));
    }
}