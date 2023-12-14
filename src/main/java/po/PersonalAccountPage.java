package po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage extends BasePage {

    private final By nameField = By.xpath(".//input[@name = 'Name']");

    private final By exitButton = By.xpath(".//button[text()='Выход']");


    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем имя")
    public String getTextFromNameField() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(driver.findElement(nameField)));
        return driver.findElement(nameField).getAttribute("value");
    }

    @Step("Нажимаем на кнопку Выйти")
    public void exitButtonClick () {
        driver.findElement(exitButton).click();
    }
}
