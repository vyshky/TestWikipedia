package org.page;

import org.openqa.selenium.WebDriver;
import org.util.PaintTextUtil;


public abstract class Page {
    protected final WebDriver driver;
    protected boolean stateOpen;
    protected final String url;

    public Page(WebDriver driver, String url) {
        if (driver == null) throw new NullPointerException(PaintTextUtil.cyan("WebDriver is null"));
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
        if (stateOpen) throw new IllegalStateException(PaintTextUtil.cyan("The page is open, please reopen the page"));
    }

    public void illegalArgumentException(String text) {

        if (text == null) throw new IllegalArgumentException(PaintTextUtil.cyan("SearchLine is null"));
    }

    public void currentUrlContainsUrl() {
        if (!driver.getCurrentUrl().contains(url)) throw new RuntimeException(PaintTextUtil.cyan("CurrentUrl != " + url));
    }
}
