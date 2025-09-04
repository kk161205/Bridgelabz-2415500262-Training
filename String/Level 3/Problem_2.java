import java.util.Scanner;

public class Problem_2 {
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // When index goes out of bounds, stop
        }
        return count;
    }

    // Method to find unique characters
    public static char[] findUniqueChars(String text) {
        int n = getLength(text);
        char[] result = new char[n];  // to store unique chars
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // check if current already appeared before
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            // if unique, add to result
            if (isUnique) {
                result[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create trimmed array of exact size
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = result[i];
        }
        return uniqueChars;
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char[] unique = findUniqueChars(input);

        System.out.print("Unique Characters: ");
        for (char c : unique) {
            System.out.print(c + " ");
        }

        sc.close();
    }
}
