import java.util.Scanner;

public class Problem_2 {
     static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) result += str.charAt(i);
        return result;
    }
    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) if (s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        String sub1 = customSubstring(text, start, end);
        String sub2 = text.substring(start, end);
        System.out.println("Custom Substring: " + sub1);
        System.out.println("Built-in Substring: " + sub2);
        System.out.println("Are Equal: " + compareStrings(sub1, sub2));
        sc.close();
    }
}
