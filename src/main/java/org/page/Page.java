package org.page;

import org.openqa.selenium.WebDriver;
import org.text.Paint;


public abstract class Page {
    protected final WebDriver driver;
    protected static WebDriver driverStatic;
    protected final String url;

    public Page(WebDriver driver, String url) {
        if (driver == null) throw new NullPointerException(Paint.cyan("WebDriver is null"));
        this.driver = driver;
        this.url = url;
    }

    public void open() {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
