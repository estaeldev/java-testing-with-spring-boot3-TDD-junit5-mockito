package br.project.test.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class DemoRepeatedTest {

    private SimpleMath math;

    @BeforeEach
    void beforeAllMethod() {
        System.out.println("Running @BeforeEach method");
        this.math = new SimpleMath();
    }

    @RepeatedTest(3)
    void testDivision_WhenByZero_ReturnException() {
        Assertions.assertThrows(ArithmeticException.class, 
            () -> math.division(5.0, 0.0));
    }

}
