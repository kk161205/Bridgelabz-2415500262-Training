import java.util.Scanner;

public class Problem_3 {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = customSplit(text);
        String[][] data = wordLengths(words);
        System.out.println("Word\tLength");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + Integer.parseInt(data[i][1]));
        }
        sc.close();
    }
}
