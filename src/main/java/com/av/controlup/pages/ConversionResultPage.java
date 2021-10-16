package com.av.controlup.pages;

import com.av.controlup.manager.web.WebManager;
import org.openqa.selenium.By;

public class ConversionResultPage extends ConversionBasePage {

    public static final By BY_RESULT = By.id("answer");

    public ConversionResultPage(WebManager driver) {
        super(driver);
    }

    public String getResult() {
        return driver.waitForElementAndGetText(BY_RESULT);
    }
}
