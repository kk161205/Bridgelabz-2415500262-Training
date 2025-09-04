import java.util.Scanner;

public class Problem_6 {
    static String charType(char c) {
        if (c >= 'A' && c <= 'Z') c = (char)(c + 32);
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }
    static String[][] classifyChars(String text) {
        String[][] arr = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            arr[i][0] = String.valueOf(text.charAt(i));
            arr[i][1] = charType(text.charAt(i));
        }
        return arr;
    }
    static void displayTable(String[][] arr) {
        System.out.println("Char\tType");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t" + arr[i][1]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] data = classifyChars(text);
        displayTable(data);
        sc.close();
    }
}
