import java.util.Scanner;

public class Problem_10 {
    public static void fibonacciIterative(int n) {
        int a = 0, b = 1;
        System.out.print("Iterative: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // Logic 2: Recursive
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Logic 3: Using Array (DP)
    public static void fibonacciArray(int n) {
        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 1) fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.print("Array (DP): ");
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i] + " ");
        }
        System.out.println();
    }

    // Logic 4: Formula (Binet's Formula)
    public static void fibonacciFormula(int n) {
        System.out.print("Formula: ");
        for (int i = 0; i < n; i++) {
            double phi = (1 + Math.sqrt(5)) / 2;
            double psi = (1 - Math.sqrt(5)) / 2;
            int fib = (int) Math.round((Math.pow(phi, i) - Math.pow(psi, i)) / Math.sqrt(5));
            System.out.print(fib + " ");
        }
        System.out.println();
    }

    // Logic 5: While Loop till limit
    public static void fibonacciWhileLimit(int limit) {
        int a = 0, b = 1;
        System.out.print("While Loop (till " + limit + "): ");
        while (a <= limit) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        // Logic 1
        fibonacciIterative(n);

        // Logic 2
        System.out.print("Recursive: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();

        // Logic 3
        fibonacciArray(n);

        // Logic 4
        fibonacciFormula(n);

        // Logic 5
        System.out.print("Enter limit for While loop: ");
        int limit = sc.nextInt();
        fibonacciWhileLimit(limit);

        sc.close();
    }
}
