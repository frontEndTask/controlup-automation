package com.av.controlup.manager.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.av.controlup.config.ConfigurationManager.configuration;

public class WebManager {

    WebDriver driver;

    public WebManager() {
        ChromeOptions chromeOptions = getChromeOptions();
        driver = new ChromeDriver(chromeOptions);
    }
    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.setHeadless(configuration().headless());
        return chromeOptions;
    }

    public WebElement waitForElement(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementVisibility(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForElementAndClick(By by) {
        waitForElement(by).click();
    }

    public void waitForElementAndSendKeys(By by, String value) {
        waitForElement(by).sendKeys(value);
    }

    public String waitForElementAndGetText(By by) {
        return waitForElement(by).getText();
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void quit() {
        driver.quit();
    }

    public void get(String url) {
        driver.get(url);
    }
}
