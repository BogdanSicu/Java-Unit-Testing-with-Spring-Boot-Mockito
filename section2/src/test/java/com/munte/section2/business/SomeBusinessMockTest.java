package com.munte.section2.business;

import com.munte.section2.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessMockTest {
    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @BeforeEach
    public void setUp() {
        business.setSomeDataService(dataServiceMock);
    }

    @Test
    public void calculateSumUsingDataService_basic() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});

        int actualResult = business.calculateSumUsingDataService();

        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { });

        int actualResult = business.calculateSumUsingDataService();

        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});

        int actualResult = business.calculateSumUsingDataService();

        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }

}