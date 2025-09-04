import java.util.Scanner;

public class Problem_7 {
    static String trimSpaces(String text) {
        int start = 0, end = text.length() - 1;

        // find first non-space
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        // find last non-space
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        // build new string
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println("Original: [" + text + "]");
        System.out.println("Trimmed : [" + trimSpaces(text) + "]");
        sc.close();
    }
}
