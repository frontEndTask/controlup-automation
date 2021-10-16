package com.av.controlup.pages;

import com.av.controlup.manager.web.WebManager;
import org.openqa.selenium.By;

import static com.av.controlup.util.GeneralUtil.sleep;

public class WeatherBasePage extends BasePage {

    public static final By BY_SEARCH_INPUT = By.id("LocationSearch_input");
    public static final By BY_GRADE_BUTTON = By.xpath("//div[@data-testid='languageSelectorSection']/button");
    public static final By BY_GRADE_CELSIUS = By.xpath("//span[contains (@class, 'UnitSelectorButtonTextC')]");
    public static final By BY_GRADE_FAHRENHEIT = By.xpath("//span[contains (@class, 'UnitSelectorButtonTextF')]");

    public WeatherBasePage(WebManager driver) {
        super(driver);
        sleep(4);
    }

    public WeatherBasePage setGradeType(By grade) {
        driver.waitForElementAndClick(BY_GRADE_BUTTON);
        driver.waitForElementAndClick(grade);
        return this;
    }

    public WeatherBasePage setSearchValue(String value) {
        driver.waitForElementAndSendKeys(BY_SEARCH_INPUT, value);
        return this;
    }

    public WeatherResultPage clickSearchResult(String value) {
        driver.waitForElementAndClick(By.xpath("//div[@id='LocationSearch_listbox']/button[text()='" + value + "']"));
        return new WeatherResultPage(driver);
    }
}
