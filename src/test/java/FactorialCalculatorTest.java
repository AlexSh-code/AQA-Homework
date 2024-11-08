import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FactorialCalculatorTest {

    @Test
    void testCalculateFactorial1(){
        FactorialCalculator calculator = new FactorialCalculator();
        Assertions.assertEquals(1, calculator.calculateFactorial(1));;
    }

    @Test
    void testCalculateFactorial2(){
        FactorialCalculator calculator = new FactorialCalculator();
        Assertions.assertEquals(120, calculator.calculateFactorial(5));
    }

    @Test
    void testCalculateFactorial3(){
        FactorialCalculator calculator = new FactorialCalculator();
        Assertions.assertEquals(100, calculator.calculateFactorial(5));
    }

    @Test
    void testCalculateFactorialNegative4(){
        FactorialCalculator calculator = new FactorialCalculator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculateFactorial(-5));
    }
}
