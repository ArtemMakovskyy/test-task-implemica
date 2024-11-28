import org.example.сity.transportation.network.CityService;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.example.Main.calculateBracketByCatalanFormula;
import static org.example.Main.calculateFactorial;
import static org.example.Main.calculateSumOfDigitsOfNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    void calculateFactorial_ValidInput_ShouldReturnCorrectFactorial() {
        assertEquals(BigInteger.ONE, calculateFactorial(0));
        assertEquals(BigInteger.ONE, calculateFactorial(1));
        assertEquals(BigInteger.valueOf(120), calculateFactorial(5));
    }

    @Test
    void calculateBracketByCatalanFormula_ValidInput_ShouldReturnCorrectCatalanNumber() {
        assertEquals(BigInteger.ONE, calculateBracketByCatalanFormula(0));
        assertEquals(BigInteger.ONE, calculateBracketByCatalanFormula(1));
        assertEquals(BigInteger.valueOf(2), calculateBracketByCatalanFormula(2));
        assertEquals(BigInteger.valueOf(5), calculateBracketByCatalanFormula(3));
    }

    @Test
    void calculateSumOfDigitsOfNumber_ValidInput_ShouldReturnCorrectSumOfDigits() {
        assertEquals(27, calculateSumOfDigitsOfNumber(new BigInteger("999")));
        assertEquals(6, calculateSumOfDigitsOfNumber(new BigInteger("123")));
        assertEquals(648, calculateSumOfDigitsOfNumber(calculateFactorial(100)));
    }

    @Test
    public void findMinCostBetweenCities_ValidCities_ShouldReturnCorrectMinCost() {
        String resultGdanskWarszawa = CityService.findMinCostBetweenCities("gdansk", "warszawa");
        String resultBydgoszczWarszawa = CityService.findMinCostBetweenCities("bydgoszcz", "warszawa");

        assertEquals("Minimum cost fromCity gdansk toCity warszawa is: 3", resultGdanskWarszawa);
        assertEquals("Minimum cost fromCity bydgoszcz toCity warszawa is: 2", resultBydgoszczWarszawa);
    }
}
