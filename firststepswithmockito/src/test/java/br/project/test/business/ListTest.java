package br.project.test.business;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

class ListTest {
    
    @Test
    void testMockitoList() {
        var listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(10).thenReturn(20);
        Mockito.when(listMock.get(1)).thenReturn("Tael");
        Mockito.when(listMock.remove(5)).thenThrow(new RuntimeException("Object not is found"));

        Assertions.assertEquals(10, listMock.size());
        Assertions.assertEquals(20, listMock.size());
        Assertions.assertEquals("Tael", listMock.get(1));
        Assertions.assertThrows(RuntimeException.class, () -> listMock.remove(5));

    }

    @Test
    void testBDDMockitoList() {
        var listMock = BDDMockito.mock(List.class);
        BDDMockito.given(listMock.size()).willReturn(10).willReturn(20);
        BDDMockito.given(listMock.get(1)).willReturn("Tael");
        BDDMockito.given(listMock.remove(5)).willThrow(new RuntimeException("Object not is found"));

        MatcherAssert.assertThat(10, Matchers.is((listMock.size())));
        MatcherAssert.assertThat(20, Matchers.is((listMock.size())));
        MatcherAssert.assertThat("Tael", Matchers.is((listMock.get(1))));
        Assertions.assertThrows(RuntimeException.class, () -> listMock.remove(5));

    }

}
