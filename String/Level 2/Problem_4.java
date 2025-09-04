import java.util.Scanner;
public class Problem_4 {
    static int customLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }
    static String[] customSplit(String str) {
        int n = customLength(str);
        int spaces = 0;
        for (int i = 0; i < n; i++) if (str.charAt(i) == ' ') spaces++;
        int[] idx = new int[spaces + 2];
        int k = 1;
        for (int i = 0; i < n; i++) if (str.charAt(i) == ' ') idx[k++] = i;
        idx[0] = -1;
        idx[k] = n;
        String[] words = new String[k];
        for (int i = 0; i < k; i++) {
            String w = "";
            for (int j = idx[i] + 1; j < idx[i + 1]; j++) w += str.charAt(j);
            words[i] = w;
        }
        return words;
    }
    static String[][] wordLengths(String[] words) {
        String[][] res = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            res[i][0] = words[i];
            res[i][1] = String.valueOf(customLength(words[i]));
        }
        return res;
    }
    static String[] shortestLongest(String[][] arr) {
        int min = Integer.parseInt(arr[0][1]);
        int max = Integer.parseInt(arr[0][1]);
        String sMin = arr[0][0], sMax = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            int len = Integer.parseInt(arr[i][1]);
            if (len < min) {
                min = len;
                sMin = arr[i][0];
            }
            if (len > max) {
                max = len;
                sMax = arr[i][0];
            }
        }
        return new String[]{sMin, sMax};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = customSplit(text);
        String[][] arr = wordLengths(words);
        String[] res = shortestLongest(arr);
        System.out.println("Shortest: " + res[0]);
        System.out.println("Longest: " + res[1]);
        sc.close();
    }
}
