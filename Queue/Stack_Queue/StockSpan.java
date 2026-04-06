package Stack_Queue;

import java.util.*;

public class StockSpan {
    static int[] calculateSpan(int[] price) {
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && price[s.peek()] <= price[i]) {
                s.pop();
            }
            span[i] = s.isEmpty() ? i + 1 : i - s.peek();
            s.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        int[] res = calculateSpan(price);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}