package com.av.controlup.testData;

import com.av.controlup.pages.ConversionHomePage;

public class ConversionTestData {

    public String conversionUrl;
    public String testValue;
    public String expectedResult;
    public ConversionHomePage.CONVERSION_TYPE type;

    public ConversionTestData(String conversionUrl, String testValue, String expectedResult,
                              ConversionHomePage.CONVERSION_TYPE type) {
        this.conversionUrl = conversionUrl;
        this.testValue = testValue;
        this.expectedResult = expectedResult;
        this.type = type;
    }

    public boolean notValid() {
        return conversionUrl == null || conversionUrl.isEmpty() || testValue == null
                || testValue.isEmpty() || expectedResult == null || expectedResult.isEmpty()
                || type == null;
    }
}
