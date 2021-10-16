package com.av.controlup.pages;

import com.av.controlup.manager.web.WebManager;
import org.openqa.selenium.By;

public class WeatherResultPage extends BasePage {

    public static final By BY_TEMPERATURE = By.xpath("//div[@data-testid='CurrentConditionsContainer']//div[@class='CurrentConditions--primary--2SVPh']/span[@data-testid='TemperatureValue']");

    public WeatherResultPage(WebManager driver) {
        super(driver);
    }

    public String getTemperatureResult() {
        return driver.waitForElementAndGetText(BY_TEMPERATURE);
    }
}
