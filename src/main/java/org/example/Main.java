package org.example;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        task1FindCorrectNumberBracketsExpressions();
//        task3CalculateFactorialThenCalculateSumOfDigitsOfNumberOfFactorial(100);
    }

    /**
     * Task to calculate the number of correct bracket expressions
     * using Catalan numbers.
     */
    public static void task1FindCorrectNumberBracketsExpressions() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Task 1\nEnter the number of pairs of brackets: ");
        int n;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    System.out.print("Number should be not 0 and non-negative: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
        System.out.println("Number of correct bracket expressions is: "
                + calculateBracketByCatalanFormula(n));
    }

    /**
     *      Find the sum of the digits in the number 100! (i.e. 100 factorial)         {Correct answer: 648}
     */
    public static void task3CalculateFactorialThenCalculateSumOfDigitsOfNumberOfFactorial(int n) {
        System.out.println("\nTask 3\nSum fo digits of factorial of number " + n + " is: " +
                calculateSumOfDigitsOfNumber(
                        calculateFactorial(n)
                )
        );
    }

    /**
     * Calculates the sum of the digits in a given number.
     *
     * @param number The number to calculate the sum of digits for
     * @return The sum of digits of the number
     */
    private static int calculateSumOfDigitsOfNumber(BigInteger number) {
        // Convert the number to a string and calculate the sum of its digits
        return number.toString()
                .chars() // Get the stream of characters
                .map(digit -> digit - '0') // Convert char to its numeric value
                .sum(); // Sum up the numeric values
    }

    /**
     * Calculates the nth Catalan number using the formula:
     * C_n = (2n)! / ((n + 1)! * n!)
     *
     * @param n Number of bracket pairs
     * @return The number of correct bracket expressions
     */
    private static BigInteger calculateBracketByCatalanFormula(int n) {
        return calculateFactorial(2 * n)
                .divide(calculateFactorial(n + 1)
                        .multiply(calculateFactorial(n)));
    }

    /**
     * Calculates the factorial of a given number.
     *
     * @param n The number to calculate the factorial for
     * @return The factorial of n
     */
    private static BigInteger calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
