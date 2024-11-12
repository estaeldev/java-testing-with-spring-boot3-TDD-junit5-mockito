package br.project.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
class MethodOrderedReadonlyTest {

    @Test
    void testA() {
        System.out.println("Running Test A");
        Assertions.assertTrue(true);
    }

    @Test
    void testB() {
        System.out.println("Running Test B");
        Assertions.assertTrue(true);
    }

    @Test
    void testC() {
        System.out.println("Running Test C");
        Assertions.assertTrue(true);
    }

    @Test
    void testD() {
        System.out.println("Running Test D");
        Assertions.assertTrue(true);
    }
    
}
