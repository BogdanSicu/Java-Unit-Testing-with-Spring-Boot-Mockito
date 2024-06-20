package com.munte.section2.business;


import com.munte.section2.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessInjectMockTest {
    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();
    @Mock
    SomeDataService dataServiceMock;

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