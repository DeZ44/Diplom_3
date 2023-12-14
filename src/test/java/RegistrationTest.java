import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import po.LoginPage;
import po.MainPage;
import po.RegistrationPage;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;

import static org.hamcrest.CoreMatchers.containsString;


public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage;
    private final String goodPassword = RandomStringUtils.randomAlphabetic(8);
    private final String badPassword = RandomStringUtils.randomAlphabetic(5);

    @Before
    @Step("Открываем Главную страницу, переходим в Регистрацию и заполнем поля: имя и email")
    public void setUp() {
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphabetic(8) + "@yandex.ru";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.personalAccountButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.needRegistrationButtonClick();
        registrationPage = new RegistrationPage(driver);
        registrationPage.setName(name);
        registrationPage.setEmail(email);
    }


    @Test
    public void checkRegistration() {
        registrationPage.setPassword(goodPassword);
        registrationPage.registrationButtonClick();
        registrationPage.waitInvisibleRegistrationButton();
        LoginPage loginPage = new LoginPage(driver);
        MatcherAssert.assertThat("Окно регистрации не исчезло",
                loginPage.checkEnterText(),
                containsString("Вход"));

    }

    @Test
    public void checkRegistrationWithBadPassword() {
        registrationPage.setPassword(badPassword);
        registrationPage.registrationButtonClick();
        MatcherAssert.assertThat("Текст не появился",
                registrationPage.checkBadRegistrationText(),
                containsString("Некорректный пароль"));

    }
}
