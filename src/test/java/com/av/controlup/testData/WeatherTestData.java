package com.av.controlup.testData;

import org.openqa.selenium.By;

public class WeatherTestData {

    public By gradeType;
    public String weatherUrl;
    public String apiUrl;
    public String zipCode;
    public String areaName;
    public String path;

    public WeatherTestData(By gradeType, String weatherUrl, String apiUrl, String zipCode, String areaName, String path) {
        this.gradeType = gradeType;
        this.weatherUrl = weatherUrl;
        this.apiUrl = apiUrl;
        this.zipCode = zipCode;
        this.areaName = areaName;
        this.path = path;
    }

    public boolean notValid() {
        return zipCode == null || zipCode.isEmpty()
                || areaName == null || areaName.isEmpty()
                || weatherUrl == null || weatherUrl.isEmpty()
                || gradeType == null;
    }
}
