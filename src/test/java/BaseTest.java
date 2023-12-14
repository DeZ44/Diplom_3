import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    @Step("Запуск браузера")
    public void startBrowser() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver("yandex");
        driver.manage().window().maximize();
    }

    @After
    @Step("Закрытие браузера")
    public void closeBrowser() {
        driver.quit();
    }

}
