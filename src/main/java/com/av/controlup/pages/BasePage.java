package com.av.controlup.pages;

import com.av.controlup.manager.web.WebManager;

public class BasePage {

    WebManager driver;
    protected BasePage(WebManager driver) {
        this.driver = driver;
    }
}
