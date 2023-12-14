package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage extends BasePage {

    private final By enterButtonFromPasswordRecovery = By.xpath(".//a[@href = '/login']");
    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажимаем на кнопку Войти со страницы Восстановления пароля")
    public void enterButtonFromPasswordRecoveryClick () {
        driver.findElement(enterButtonFromPasswordRecovery).click();
    }
}
