import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testCalculateFactorial1(){
        FactorialCalculator calculator = new FactorialCalculator();
        Assert.assertEquals(calculator.calculateFactorial(1), 1);
    }

    @Test
    public void testCalculateFactorial2(){
        FactorialCalculator calculator = new FactorialCalculator();
        Assert.assertEquals(calculator.calculateFactorial(5), 120);
    }

    @Test
    public void testCalculateFactorial3(){
        FactorialCalculator calculator = new FactorialCalculator();
        Assert.assertEquals(calculator.calculateFactorial(5), 100);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testCalculateFactorialNegative(){
        FactorialCalculator calculator = new FactorialCalculator();
        calculator.calculateFactorial(-1);
    }
}
