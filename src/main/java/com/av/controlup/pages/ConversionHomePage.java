package com.av.controlup.pages;

import com.av.controlup.manager.web.WebManager;
import org.openqa.selenium.By;

public class ConversionHomePage extends ConversionBasePage {

    public enum CONVERSION_TYPE {
        CelsiusToFahrenheit("Celsius", "Fahrenheit", BY_CONVERSION_VALUE_TEMP, BY_CONVERT_BUTTON_TEMP),
        MetersToFeet("Meters", "Feet", BY_CONVERSION_VALUE_LENGTH, BY_CONVERT_BUTTON_LENGTH),
        OuncesToGrams("Ounces", "Grams", BY_CONVERSION_VALUE_WEIGHT, BY_CONVERT_BUTTON_WEIGHT),
        ;

        public String from;
        public String to;
        public By value;
        public By button;

        CONVERSION_TYPE(String from, String to, By value, By button) {
            this.from = from;
            this.to = to;
            this.value = value;
            this.button = button;
        }
    }

    public static final By BY_CONVERSION_VALUE_TEMP = By.xpath("//section[@id='search']//h2[text()='Celsius to Fahrenheit']/following-sibling::div[@class='convertForm']/input");
    public static final By BY_CONVERSION_VALUE_WEIGHT = By.xpath("//section[@id='search']//h2[text()='Ounces to Grams']/following-sibling::div[@class='convertForm']/input");
    public static final By BY_CONVERSION_VALUE_LENGTH = By.xpath("//section[@id='search']//h2[text()='Meters to Feet']/following-sibling::div[@class='convertForm']/input");
    public static final By BY_CONVERT_BUTTON_TEMP = By.xpath("//section[@id='search']//h2[text()='Celsius to Fahrenheit']/following-sibling::div[@class='convertForm']//a[text() ='Convert']");
    public static final By BY_CONVERT_BUTTON_WEIGHT = By.xpath("//section[@id='search']//h2[text()='Ounces to Grams']/following-sibling::div[@class='convertForm']//a[text() ='Convert']");
    public static final By BY_CONVERT_BUTTON_LENGTH = By.xpath("//section[@id='search']//h2[text()='Meters to Feet']/following-sibling::div[@class='convertForm']//a[text() ='Convert']");
    public static final By BY_CONVERT_TO = By.id("queryTo");
    public static final By BY_CONVERT_FROM = By.id("queryFrom");

    public ConversionHomePage(WebManager driver) {
        super(driver);
    }

    public ConversionHomePage setConvertFrom(String from) {
        waitForSection(SECTION.userInput);
        driver.waitForElementAndSendKeys(BY_CONVERT_FROM, from);
        return this;
    }

    public ConversionHomePage setConvertTo(String to) {
        waitForSection(SECTION.search);
        driver.waitForElementAndSendKeys(BY_CONVERT_TO, to);
        return this;
    }

    public ConversionHomePage setConversionValue(String value, By by) {
        driver.waitForElementAndSendKeys(by, value);
        return this;
    }

    public ConversionResultPage clickConvert(By by) {
        driver.waitForElementAndClick(by);
        return new ConversionResultPage(driver);
    }
}
