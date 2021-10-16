package com.av.controlup.pages;

import com.av.controlup.manager.web.WebManager;
import org.openqa.selenium.By;

public class ConversionBasePage extends BasePage {

    protected ConversionBasePage(WebManager driver) {
        super(driver);
    }

    public enum SECTION {
        userInput, search, result
        ;
        public By getSectionBy() {
            return By.cssSelector("section#" + name());
        }
    }

    protected void waitForSection(ConversionHomePage.SECTION section) {
        driver.waitForElementVisibility(section.getSectionBy());
    }
}
