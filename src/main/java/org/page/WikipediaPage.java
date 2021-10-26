package org.page;

import org.openqa.selenium.*;

public final class WikipediaPage extends Page {
    private static final String url = "https://ru.wikipedia.org";
    private By searchLine = By.cssSelector("input[accesskey='f']");
    private By searchSuggestion = By.cssSelector("div[rel='0']");
    private WebElement searchInputElement;
    private WebElement searchSuggestionElement;


    public WikipediaPage(WebDriver driver) {
        super(driver, url);
        System.out.println(driver.getWindowHandle().toString());
    }

    public void setSearchText(String text) {
        illegalArgumentException(text);
        currentUrlContainsUrl();
        searchInputElement = driver.findElement(searchLine);
        this.searchInputElement.sendKeys(text);
        System.out.println(searchInputElement);
    }

    public void checkSuggestions() {
        currentUrlContainsUrl();
        searchSuggestionElement = driver.findElement(searchSuggestion);
        System.out.println(searchSuggestionElement);
    }

}
