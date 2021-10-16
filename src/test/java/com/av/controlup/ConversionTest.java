package com.av.controlup;

import com.av.controlup.pages.ConversionHomePage;
import com.av.controlup.pages.ConversionResultPage;
import com.av.controlup.testData.ConversionTestData;
import com.av.controlup.testData.TestDataFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConversionTest extends BaseTest {

    @Test(dataProvider = "conversionData", dataProviderClass = TestDataFactory.class)
    public void testConversion(ConversionTestData testData) {
        driver.get(testData.conversionUrl);
        ConversionHomePage conversionHomePage = new ConversionHomePage(driver);
        ConversionResultPage conversionResultPage = conversionHomePage
                .setConvertFrom(testData.type.from)
                .setConvertTo(testData.type.to)
                .setConversionValue(testData.testValue, testData.type.value)
                .clickConvert(testData.type.button);

        String actualResult = conversionResultPage.getResult();

        logResults(testData.expectedResult, actualResult);
        testResult(testData, actualResult);
    }

    private void testResult(ConversionTestData testData, String actualResult) {
        Assert.assertEquals(actualResult.replaceAll("[^a-zA-Z0-9]", ""),
                testData.expectedResult.replaceAll("[^a-zA-Z0-9]", ""));
    }
}

