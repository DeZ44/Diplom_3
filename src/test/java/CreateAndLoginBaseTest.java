import data.UserData;
import data.UserRest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import po.LoginPage;
import po.MainPage;

import java.util.concurrent.TimeUnit;

import static constans.url.WEBSITE_URL;

public class CreateAndLoginBaseTest extends BaseTest {
    UserRest userRest;
    UserData user;
    private String accessToken;
    protected String email;
    protected String password;
    protected String name;
    MainPage mainPage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        email = RandomStringUtils.randomAlphabetic(8) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(8);
        name = RandomStringUtils.randomAlphabetic(8);
        userRest = new UserRest();
        user = new UserData(email, password, name);
        RestAssured.baseURI = WEBSITE_URL;
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Response response = userRest.createUser(user);
        accessToken = response.path("accessToken");
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.enterToAccountButtonClick();
        loginPage = new LoginPage(driver);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.enterButtonClick();
    }

    @After
    public void deleteUser() {
        userRest.deleteUser(accessToken);
    }
}
