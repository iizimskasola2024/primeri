package si.um.feri.junit.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryCalculatorTest {

    @Test
    public void testCorrectSalaryCalculation() {
        SalaryCalculator sc=new SalaryCalculator(12.5,120,0.05);
        double expected=1575.0;
        assertEquals(sc.calculate(),expected,0.001);
    }

    @Test
    public void testWrongSalaryCalculation() {
        SalaryCalculator sc=new SalaryCalculator(12.5,120,0.05);
        double notExpected=1500.0;
        assertNotEquals(sc.calculate(),notExpected,0.001);
    }

}
