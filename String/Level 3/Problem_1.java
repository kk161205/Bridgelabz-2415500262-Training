import java.util.Scanner;

class Problem_1 {
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;  // convert cm to m
        double bmi = weight / (heightM * heightM);

        String status;
        if (bmi < 18.5)
            status = "Underweight";
        else if (bmi < 25)
            status = "Normal";
        else if (bmi < 30)
            status = "Overweight";
        else
            status = "Obese";

        return new String[]{String.format("%.2f", bmi), status};
    }

    // Method to compute BMI table
    public static String[][] computeBMITable(double[][] data) {
        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1];

            String[] bmiResult = calculateBMI(weight, height);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiResult[0];
            result[i][3] = bmiResult[1];
        }
        return result;
    }

    // Method to display BMI table
    public static void displayTable(String[][] table) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------");

        for (String[] row : table) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][2]; // 10 rows, 2 cols (weight, height)

        System.out.println("Enter weight(kg) and height(cm) for 10 persons:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " Weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        // Compute & Display
        String[][] resultTable = computeBMITable(data);
        displayTable(resultTable);

        sc.close();
    }
}