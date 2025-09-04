import java.util.Scanner;
public class Problem_5 {
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // index out of range → stop
        }
        return count;
    }

    // Method to find unique characters
    public static char[] findUniqueChars(String text) {
        int n = getLength(text);
        char[] result = new char[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                result[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Trim to actual unique size
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = result[i];
        }
        return uniqueChars;
    }

    // Method to find frequency using unique chars
    public static String[][] findFrequency(String text) {
        char[] unique = findUniqueChars(text);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            char c = unique[i];
            int count = 0;

            for (int j = 0; j < getLength(text); j++) {
                if (text.charAt(j) == c) {
                    count++;
                }
            }

            result[i][0] = String.valueOf(c);
            result[i][1] = String.valueOf(count);
        }

        return result;
    }

    // Display Method
    public static void displayFrequency(String[][] table) {
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("----------------------");

        for (String[] row : table) {
            System.out.printf("%-10s %-10s\n", row[0], row[1]);
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = findFrequency(input);
        displayFrequency(result);

        sc.close();
    }
}
