package br.project.test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class ArraysCompareTest {

    @Test
    void test(){
        int[] numbes = {25, 8, 21, 32, 3};
        int[] expectedArray = {3, 8, 21, 25, 32};
        Arrays.sort(numbes);
        Assertions.assertArrayEquals(numbes, expectedArray);
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testSortPerformance(){
        int[] numbes = {25, 8, 21, 32, 3};
        Arrays.sort(numbes);
        Assertions.assertTrue(true);
    }
    
}
