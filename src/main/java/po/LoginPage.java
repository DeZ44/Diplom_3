package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private final By needRegistrationButton = By.xpath(".//a[text()='Зарегистрироваться']");

    private final By enterText = By.xpath(".//div[@class = 'Auth_login__3hAey']/h2");

    private final By emailField = By.xpath(".//label[text() = 'Email']/parent::div/input");

    private final By passwordField = By.xpath(".//label[text() = 'Пароль']/parent::div/input");

    private final By enterButton = By.xpath(".//button[text()='Войти']");

    private final By passwordRecoveryButton = By.xpath(".//a[@href = '/forgot-password']");




    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке Зарегистрироваться для начала регистрации")
    public void needRegistrationButtonClick () {
        driver.findElement(needRegistrationButton).click();
    }

    public String checkEnterText() {
        return driver.findElement(enterText).getText();
    }

    @Step("Заполняем поле email на странице авторизации")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполняем поле Пароль на странице авторизации")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик на кнопку Войти")
    public void enterButtonClick () {
        driver.findElement(enterButton).click();
    }

    @Step("Клик на кнопку Восстановить пароль")
    public void passwordRecoveryButtonClick () {
        driver.findElement(passwordRecoveryButton).click();
    }

    @Step("Ожидаем появление кнопки Войти")
    public void waitEnterButtonVisibility() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(driver.findElement(enterButton)));
    }



}
