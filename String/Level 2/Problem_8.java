import java.util.Scanner;

public class Problem_8 {
    static String replaceSpaces(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                result += '-';
            } else {
                result += c;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println("Modified: " + replaceSpaces(text));
        sc.close();
    }
}
