import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.example.Main.calculateBracketByCatalanFormula;
import static org.example.Main.calculateFactorial;
import static org.example.Main.calculateSumOfDigitsOfNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    void testCalculateFactorial() {
        assertEquals(BigInteger.ONE, calculateFactorial(0));
        assertEquals(BigInteger.ONE, calculateFactorial(1));
        assertEquals(BigInteger.valueOf(120), calculateFactorial(5));
    }

    @Test
    void testCalculateBracketByCatalanFormula() {
        assertEquals(BigInteger.ONE, calculateBracketByCatalanFormula(0));
        assertEquals(BigInteger.ONE, calculateBracketByCatalanFormula(1));
        assertEquals(BigInteger.valueOf(2), calculateBracketByCatalanFormula(2));
        assertEquals(BigInteger.valueOf(5), calculateBracketByCatalanFormula(3));
    }

    @Test
    void testCalculateSumOfDigitsOfNumber() {
        assertEquals(27, calculateSumOfDigitsOfNumber(new BigInteger("999")));
        assertEquals(6, calculateSumOfDigitsOfNumber(new BigInteger("123")));
        assertEquals(648, calculateSumOfDigitsOfNumber(calculateFactorial(100)));
    }
}
