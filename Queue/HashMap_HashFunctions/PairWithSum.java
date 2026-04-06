package HashMap_HashFunctions;

import java.util.*;

public class PairWithSum {
    static boolean hasPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (set.contains(target - x)) return true;
            set.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,45,6,10,8};
        System.out.println(hasPair(arr, 16));
    }
}