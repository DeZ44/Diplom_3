package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    private final By builderButton = By.xpath(".//p[text()='Конструктор']");

    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Клик по Личному кабинету")
    public void personalAccountButtonClick () {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Клик по кнопке Конструктор")
    public void builderButtonClick () {
        driver.findElement(builderButton).click();
    }

    @Step("Клик на логотип")
    public void logoButtonClick () {
        driver.findElement(logoButton).click();
    }
}
