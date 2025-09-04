import java.util.Scanner;
public class Problem_6 {
    public static String[] findFrequency(String text) {
        char[] chars = text.toCharArray();
        int n = chars.length;
        int[] freq = new int[n];

        // Count frequencies
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') continue; // already counted

            freq[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // Count unique characters
        int uniqueCount = 0;
        for (int f : freq) {
            if (f > 0) uniqueCount++;
        }

        // Store result in 1D String array
        String[] result = new String[uniqueCount];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (freq[i] > 0 && chars[i] != '0') {
                result[index] = chars[i] + " → " + freq[i];
                index++;
            }
        }
        return result;
    }

    // Display Method
    public static void displayFrequency(String[] freqArray) {
        System.out.println("Character Frequencies:");
        for (String s : freqArray) {
            System.out.println(s);
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[] result = findFrequency(input);
        displayFrequency(result);

        sc.close();
    }
}
