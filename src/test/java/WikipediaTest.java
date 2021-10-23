import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.page.WikipediaPage;
import org.text.Paint;

import java.util.concurrent.TimeUnit;

public final class WikipediaTest {
    private final String url = "https://ru.wikipedia.org";
    private WebDriver driver;

    @BeforeClass
    public static void initProperties() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    @Before
    public void initWebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get(url);

        try {
            WikipediaPage page = new WikipediaPage(driver);
            page.setSearchText("Во все тяжкие");
            page.searchSuggestions();
        } catch (WebDriverException e) {
            e.printStackTrace();
            String textError = Paint.cyan("Поисковые подсказки не найден");
            Assert.fail(textError);
        }
    }

    @After
    public void CloseDriver() {
        try {
            driver.quit();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
//Нажимаем ENTER
//searchInputElement.sendKeys(Keys.ENTER);
//Нажимаем кнопку
//WebElement btnK = driver.findElement(By.cssSelector("input[id=searchButton]"));
// btnK.click();  // btnK.sendKeys(Keys.ENTER);
////////////////////////////////////////////////////////////////////////////////////////////////////
