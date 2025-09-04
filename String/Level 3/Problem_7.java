import java.util.Scanner;
public class Problem_7 {
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive comparison
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Reverse string and compare
    public static boolean isPalindromeReverse(String text) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        return text.equals(reversed);
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String input = sc.nextLine();

        // Logic 1
        System.out.println("Palindrome (Iterative): " + isPalindromeIterative(input));

        // Logic 2
        System.out.println("Palindrome (Recursive): " + isPalindromeRecursive(input, 0, input.length() - 1));

        // Logic 3
        System.out.println("Palindrome (Reverse Compare): " + isPalindromeReverse(input));

        sc.close();
    }
}
