package com.av.controlup;

import com.av.controlup.manager.api.ApiManager;
import com.av.controlup.pages.WeatherBasePage;
import com.av.controlup.testData.TestDataFactory;
import com.av.controlup.testData.WeatherTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherTest extends BaseTest {

    @Test(dataProvider = "weatherData", dataProviderClass = TestDataFactory.class)
    public void testWeather(WeatherTestData testData) {
        Double webResult = getWebResult(testData);
        Double apiResult = getApiResult(testData);
        logResults(webResult, apiResult);
        Assert.assertEquals(webResult, apiResult, webResult/10);
    }

    private Double getApiResult(WeatherTestData testData) {
        return ApiManager.getDoubleValue(testData.apiUrl, testData.path);
    }

    private Double getWebResult(WeatherTestData testData) {
        driver.get(testData.weatherUrl);
        WeatherBasePage weatherBasePage = new WeatherBasePage(driver);
        String webResult = weatherBasePage
                .setGradeType(testData.gradeType)
                .setSearchValue(testData.zipCode)
                .clickSearchResult(testData.areaName)
                .getTemperatureResult();

        return getWebResultDouble(webResult);
    }

    private Double getWebResultDouble(String webResult) {
        webResult = webResult.replaceAll("[^a-zA-Z0-9.]", "");
        return Double.valueOf(webResult);
    }
}
