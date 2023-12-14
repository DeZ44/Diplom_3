import data.UserData;
import data.UserRest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.LoginPage;
import po.MainPage;
import po.PasswordRecoveryPage;
import po.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static constans.url.WEBSITE_URL;
import static org.hamcrest.CoreMatchers.containsString;

public class LoginTest extends BaseTest {

    UserRest userRest;
    UserData user;
    MainPage mainPage;
    LoginPage loginPage;
    String accessToken;
    private String email;
    private String password;


    @Before
    public void setUp() {
        email = RandomStringUtils.randomAlphabetic(8) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(8);
        String name = RandomStringUtils.randomAlphabetic(8);
        userRest = new UserRest();
        user = new UserData(email, password, name);
        RestAssured.baseURI = WEBSITE_URL;
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Response response = userRest.createUser(user);
        accessToken = response.path("accessToken");
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        loginPage = new LoginPage(driver);
    }

    @After
    public void deleteUser() {
        userRest.deleteUser(accessToken);
    }


   @Test
   public void checkLoginMainButton() {
       mainPage.enterToAccountButtonClick();
       loginPage.setEmail(email);
       loginPage.setPassword(password);
       loginPage.enterButtonClick();
       MatcherAssert.assertThat("Окно входа не исчезло",
               mainPage.checkTitleMainPage(),
               containsString("Соберите бургер"));

   }

    @Test
    public void checkLoginHeaderButton() {
        mainPage.personalAccountButtonClick();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.enterButtonClick();
        MatcherAssert.assertThat("Окно входа не исчезло",
                mainPage.checkTitleMainPage(),
                containsString("Соберите бургер"));

    }

    @Test
    public void checkLoginFromRegistrationPage() {
        mainPage.personalAccountButtonClick();
        loginPage.needRegistrationButtonClick();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterButtonFromRegistrationClick();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.enterButtonClick();
        MatcherAssert.assertThat("Окно входа не исчезло",
                mainPage.checkTitleMainPage(),
                containsString("Соберите бургер"));

    }

    @Test
    public void checkLoginFromPasswordRecoveryPage() {
        mainPage.personalAccountButtonClick();
        loginPage.passwordRecoveryButtonClick();
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.enterButtonFromPasswordRecoveryClick();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.enterButtonClick();
        MatcherAssert.assertThat("Окно входа не исчезло",
                mainPage.checkTitleMainPage(),
                containsString("Соберите бургер"));

    }

}
