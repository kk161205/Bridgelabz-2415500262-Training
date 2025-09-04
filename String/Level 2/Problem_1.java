import java.util.Scanner;

public class Problem_1 {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int len1 = customLength(text);
        int len2 = text.length();
        System.out.println("Custom Length: " + len1);
        System.out.println("Built-in Length: " + len2);
        sc.close();
    }
}
