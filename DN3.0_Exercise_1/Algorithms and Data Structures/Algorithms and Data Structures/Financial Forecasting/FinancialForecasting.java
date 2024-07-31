public class FinancialForecasting {

    // Recursive method to calculate future value
    public double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: when years are 0, the future value is the present value
        if (years == 0) {
            return presentValue;
        }

        // Recursive case: apply growth rate and reduce years
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter the present value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (as a decimal): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        // Calculate future value
        double futureValue = forecasting.calculateFutureValue(presentValue, growthRate, years);
        System.out.println("The future value after " + years + " years is: " + futureValue);
    }
}
