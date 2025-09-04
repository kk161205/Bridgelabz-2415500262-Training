import java.util.Scanner;

public class Problem_7 {
    static void generateException(String text) {
        int num = Integer.parseInt(text);
        System.out.println(num);
    }
    static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        //generateException(text);
        handleException(text);
        sc.close();
    }
}
