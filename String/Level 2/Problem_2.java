import java.util.Scanner;

public class Problem_2 {
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
    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (!a[i].equals(b[i])) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] arr1 = customSplit(text);
        String[] arr2 = text.split(" ");
        System.out.println("Are Equal: " + compareArrays(arr1, arr2));
        sc.close();
    }
}