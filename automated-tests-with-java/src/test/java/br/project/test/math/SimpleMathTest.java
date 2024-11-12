package br.project.test.math;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleMathTest {

    private SimpleMath math;

    @BeforeAll
    static void setup() {
        System.out.println("Running @BeforeAll method");
    }

    @BeforeEach
    void beforeAllMethod() {
        System.out.println("Running @BeforeEach method");
        this.math = new SimpleMath();
    }

    @Test
    void testSum(){
        Double result = math.sum(6.2, 2.0);
        Assertions.assertEquals(8.2, result);
    }

    @Test
    void testDivision() {
        Double result = math.division(10.0, 2.0);
        Assertions.assertEquals(5.0, result);
    }

    @Test
    void testDivision_WhenByZero_ReturnException() {
        Assertions.assertThrows(ArithmeticException.class, 
            () -> math.division(5.0, 0.0));
    }
    
    @Test
    void testMean() {
        Double result = math.mean(20.0, 20.0);
        Assertions.assertEquals(20.0, result);
    }

    @Test
    void testMultiplication() {
        Double result = math.multiplication(5.0, 2.0);
        Assertions.assertEquals(10.0, result);
    }

    @Test
    void testSquareRoot() {
        Double result = math.squareRoot(36.0);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testSubtraction() {
        Double result = math.subtraction(10.0, 5.0);
        Assertions.assertEquals(5.0, result);
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Running @AfterEach method");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Running @AfterAll method");
    }

}
