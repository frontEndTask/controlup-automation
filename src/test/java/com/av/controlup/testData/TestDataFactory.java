package com.av.controlup.testData;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

import static com.av.controlup.config.ConfigurationManager.*;
import static com.av.controlup.pages.WeatherBasePage.BY_GRADE_CELSIUS;
import static com.av.controlup.pages.WeatherBasePage.BY_GRADE_FAHRENHEIT;

public class TestDataFactory {

    @DataProvider(name = "conversionData")
    public static Object[][] conversionTestData() {

        ConversionTestData weightTestData = new ConversionTestData(conversionTestConfiguration().conversionUrl(), conversionTestConfiguration().weightValue(), conversionTestConfiguration().weightExpectedValue(), conversionTestConfiguration().weightType());
        ConversionTestData lengthTestData = new ConversionTestData(conversionTestConfiguration().conversionUrl(), conversionTestConfiguration().lengthValue(), conversionTestConfiguration().lengthExpectedValue(), conversionTestConfiguration().lengthType());
        ConversionTestData tempTestData = new ConversionTestData(conversionTestConfiguration().conversionUrl(), conversionTestConfiguration().tempValue(), conversionTestConfiguration().tempExpectedValue(), conversionTestConfiguration().tempType());

        List<ConversionTestData> testDataList = new ArrayList<>();
        testDataList.add(weightTestData);
        testDataList.add(lengthTestData);
        testDataList.add(tempTestData);
        testDataList.removeIf(ConversionTestData::notValid);

        Object[][] dataArray = new Object[testDataList.size()][1];
        for (int i = 0; i < testDataList.size(); i++) {
            dataArray[i][0] = testDataList.get(i);
        }
        return dataArray;
    }

    @DataProvider(name = "weatherData")
    public static Object[][] weatherTestData() {

        By gradeTypeBy = temperatureTestConfiguration().gradeType().equals("F") ? BY_GRADE_FAHRENHEIT : BY_GRADE_CELSIUS;
        String path = "current.temp_" + temperatureTestConfiguration().gradeType().toLowerCase();
        WeatherTestData weatherTestData = new WeatherTestData(gradeTypeBy, temperatureTestConfiguration().weatherUrl(), temperatureTestConfiguration().apiUrl(), temperatureTestConfiguration().zipCode(), temperatureTestConfiguration().areaName(), path);

        List<WeatherTestData> testDataList = new ArrayList<>();
        testDataList.add(weatherTestData);
        testDataList.removeIf(WeatherTestData::notValid);

        Object[][] dataArray = new Object[testDataList.size()][1];
        for (int i = 0; i < testDataList.size(); i++) {
            dataArray[i][0] = testDataList.get(i);
        }
        return dataArray;
    }
}
