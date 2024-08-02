package Finance;
/*withput optimization 
 * public class FinancialForecasting {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return (currentValue * (1 + growthRate)) * calculateFutureValue(currentValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double currentValue = 1000;
        double growthRate = 0.05;
        int years = 5;

        double futureValue = calculateFutureValue(currentValue, growthRate, years);

        System.out.println("Future value: " + futureValue);
    }
}
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
//with optimization
public class FinancialForecasting {

    private static double[] memo;

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = (currentValue * (1 + growthRate)) * calculateFutureValue(currentValue, growthRate, years - 1);
        return memo[years];
    }

    public static void main(String[] args) {
        double currentValue = 1000;
        double growthRate = 0.05;
        int years = 5;

        memo = new double[years + 1];

        double futureValue = calculateFutureValue(currentValue, growthRate, years);

        System.out.println("Future value: " + futureValue);
    }
}