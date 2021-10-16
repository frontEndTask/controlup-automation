package com.av.controlup;

import com.av.controlup.manager.web.WebManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    WebManager driver;

    @BeforeSuite
    void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupTest() {
        driver = new WebManager();
    }

    @AfterMethod(alwaysRun = true)
    void teardown() {
        driver.quit();
    }

    protected void logResults(Object expected, Object actual) {
        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);
    }
}
