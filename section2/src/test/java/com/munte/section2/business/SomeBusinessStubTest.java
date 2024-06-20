package com.munte.section2.business;

import com.munte.section2.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}


class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        business.setSomeDataService(new SomeDataServiceStub());

        int actualResult = business.calculateSumUsingDataService();

        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        int actualResult = business.calculateSum(new int[] { });

        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        int actualResult = business.calculateSum(new int[] { 5 });

        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }

}