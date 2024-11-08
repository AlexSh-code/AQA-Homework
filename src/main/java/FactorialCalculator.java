public class FactorialCalculator {
    public long calculateFactorial (int a) {
        if (a<0) {
            throw new IllegalArgumentException("Число не должно быть негативным");
        }
        long result = 1;
        for (int i=1; i<=a; i++) {
            result *= i;
        }
        return result;
    }
}
