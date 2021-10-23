package org.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WikipediaPage {
    private final WebDriver driver;
    private final WebElement searchInputElement;
    private WebElement searchSuggestion;

    public WikipediaPage(WebDriver driver) {
        this.driver = driver;
        searchInputElement = driver.findElement(By.cssSelector("input[accesskey='f']"));
    }

    public void setSearchText(String text) {
        this.searchInputElement.sendKeys(text);
    }

    public void searchSuggestions() {
        searchSuggestion = driver.findElement(By.cssSelector("div[rel='0']"));
    }
}
