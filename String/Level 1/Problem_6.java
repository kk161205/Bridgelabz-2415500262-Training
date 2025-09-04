import java.util.Scanner;

public class Problem_6 {
    static void generateException(String text) {
        System.out.println(text.substring(5, 2));
    }
    static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IllegalArgumentException");
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
