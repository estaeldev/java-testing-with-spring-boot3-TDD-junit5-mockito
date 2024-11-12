package br.project.test.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SimpleMathS4Test {

    private SimpleMath math;

    @BeforeEach
    void beforeAllMethod() {
        System.out.println("Running @BeforeEach method");
        this.math = new SimpleMath();
    }

    @ParameterizedTest
    // @CsvSource({
    //     "6.2,2,3.1",
    //     "71,14,5.07",
    //     "18.3,3.1,5.90"
    // })
    @CsvFileSource(resources = "/testDivision.csv")
    void testDivision(double firstNumber, double secondNumber, double expected) {
        Double result = math.division(firstNumber, secondNumber);
        Assertions.assertEquals(expected, result, 2D);
    }

    @ParameterizedTest
    @CsvSource({"5.0,0.0"})
    void testDivision_WhenByZero_ReturnException(double firstNumber, double secondNumber) {
        Assertions.assertThrows(ArithmeticException.class, 
            () -> math.division(firstNumber, secondNumber));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"Pele", "Senna", "Keith Moon"})
    void testValueSource(String firstName) {
        System.out.println(firstName);
        Assertions.assertNotNull(firstName);
    }

    

}
