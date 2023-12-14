import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
        public WebDriver getWebDriver(String browser) {
            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                    return new ChromeDriver();
                default:
                    return new ChromeDriver();
            }
        }
    }

