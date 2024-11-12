package br.project.test.service;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class MyUtilsTest {

    @Test
    void testGetWelcome() {
        try (MockedStatic<MyUtils> mockedStatic = Mockito.mockStatic(MyUtils.class)) {
            mockedStatic
                .when(() -> MyUtils.getWelcome(anyString(), anyBoolean()))
                .thenReturn("Howdy Tael");

            Assertions.assertEquals("Howdy Tael", MyUtils.getWelcome("", false));
        }

    }

}
