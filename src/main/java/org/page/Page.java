package org.page;

import org.openqa.selenium.WebDriver;
import org.text.Paint;


public abstract class Page {
    protected final WebDriver driver;
    protected static WebDriver driverStatic;
    protected boolean stateOpen;
    protected final String url;

    public Page(WebDriver driver, String url) {
        if (driver == null) throw new NullPointerException(Paint.cyan("WebDriver is null"));
        this.driver = driver;
        this.url = url;
        stateOpen = false;
    }


    public void open() {
        driver.get(url);
        stateIsOpen(stateOpen);
        stateOpen = true;
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void stateIsOpen(boolean stateOpen) {
        if (stateOpen) throw new IllegalStateException(Paint.cyan("The page is open, please reopen the page"));
    }

    public void illegalArgumentException(String text) {

        if (text == null) throw new IllegalArgumentException(Paint.cyan("SearchLine is null"));
    }

    public void CurrentUrlContainsUrl() {
        if (!driver.getCurrentUrl().contains(url)) throw new RuntimeException(Paint.cyan("CurrentUrl != " + url));
    }
}
