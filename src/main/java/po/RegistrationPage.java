package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

    private final By nameField = By.xpath(".//label[text() = 'Имя']/parent::div/input");

    private final By emailField = By.xpath(".//label[text() = 'Email']/parent::div/input");

    private final By passwordField = By.xpath(".//label[text() = 'Пароль']/parent::div/input");

    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");

    private final By badRegistrationText = By.xpath(".//p[contains(@class, 'input__error')]");

    private final By enterButtonFromRegistration = By.xpath(".//a[@href = '/login']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполняем поле Имя")
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполняем поле email")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполняем поле Пароль")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик на кнопку Зарегистрироваться для окончания регистрации")
    public void registrationButtonClick () {
        driver.findElement(registrationButton).click();
    }

    @Step("Ожидаем исчезновения кнопки Зарегистрироваться")
    public void waitInvisibleRegistrationButton () {
        new WebDriverWait(driver, 2).until(ExpectedConditions.invisibilityOf(driver.findElement(registrationButton)));
    }

    public String checkBadRegistrationText() {
        return driver.findElement(badRegistrationText).getText();
    }

    @Step("Клик по кнопке Войти со страницы Регистрации")
    public void enterButtonFromRegistrationClick () {
        driver.findElement(enterButtonFromRegistration).click();
    }

}
