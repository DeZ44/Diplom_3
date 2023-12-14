package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constans.url.WEBSITE_URL;

public class MainPage extends BasePage{

    private final By enterToAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    private final By titleMainPage = By.xpath(".//h1");

    private final By sauceButton = By.xpath(".//span[text() = 'Соусы']/parent::div");

    private final By fillingButton = By.xpath(".//span[text() = 'Начинки']/parent::div");

    private final By bunsButton = By.xpath(".//span[text() = 'Булки']/parent::div");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открываем главную страницу")
    public void openMainPage(){
        driver.get(WEBSITE_URL);
    }

    @Step("Нажимаем на кнопку Войти в аккаунт")
    public void enterToAccountButtonClick () {
        driver.findElement(enterToAccountButton).click();
    }

    public String checkTitleMainPage() {
        return driver.findElement(titleMainPage).getText();
    }

    @Step("Нажимаем на кнопку Соусы")
    public void sauceButtonClick () {
        driver.findElement(sauceButton).click();
    }

    public String getSauceButtonClass() {
        return driver.findElement(sauceButton).getAttribute("class");
    }

    @Step("Нажимаем на кнопку Начинки")
    public void fillingButtonClick () {
        driver.findElement(fillingButton).click();
    }

    public String getFillingButtonClass() {
        return driver.findElement(fillingButton).getAttribute("class");
    }

    @Step("Нажимаем на кнопку Булки")
    public void bunsButtonClick () {
        driver.findElement(bunsButton).click();
    }

    public String getBunsButtonClass() {
        return driver.findElement(bunsButton).getAttribute("class");
    }
}
