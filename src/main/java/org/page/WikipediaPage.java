package org.page;

import org.openqa.selenium.*;
import org.text.Paint;

public final class WikipediaPage extends Page {
    private static final String url = "https://ru.wikipedia.org";
    private String searchLine = "input[accesskey='f']";
    private WebElement searchInputElement;
    private WebElement searchSuggestion;


    public WikipediaPage(WebDriver driver) {
        super(driver, url);
        System.out.println(driver.getWindowHandle().toString());
    }

    public void setSearchText(String text) {
        illegalArgumentException(text);
        CurrentUrlContainsUrl();
        searchInputElement = driver.findElement(By.cssSelector(searchLine));
        this.searchInputElement.sendKeys(text);
        System.out.println(searchInputElement);
    }

    public void checkSuggestions() {
        CurrentUrlContainsUrl();
        searchSuggestion = driver.findElement(By.cssSelector("div[rel='0']"));
        System.out.println(searchSuggestion);
    }

}
