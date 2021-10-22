package org;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.security.Key;

public class wiki {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        var temp = System.getProperty("webdriver.chrome.driver");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.ANY);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platform", "ANY");
        capabilities.setCapability("version", "");


//        WebDriver googleProperty = new ChromeDriver(capabilities);
//        googleProperty.quit();
//
//        WebDriver googleInterface = new ChromeDriver();
//        googleInterface.quit();

        WebDriver googleChrome = new ChromeDriver();


        try {
            googleChrome.manage().window().maximize();
            googleChrome.get("https://google.ru");

            WebElement searchInputElement = googleChrome.findElement(By.cssSelector("input[name='q']"));
            searchInputElement.sendKeys("HelloWorld");

            WebElement btnK = googleChrome.findElement(By.name("btnK"));
            Thread.sleep(1000);
            btnK.click();  // btnK.sendKeys(Keys.ENTER);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(2000);
            googleChrome.quit();
        }

    }
}
