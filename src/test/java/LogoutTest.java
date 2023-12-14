import org.hamcrest.MatcherAssert;
import org.junit.Test;
import po.PersonalAccountPage;

import static org.hamcrest.CoreMatchers.containsString;

public class LogoutTest extends CreateAndLoginBaseTest{

    @Test
    public void logoutTest() {
        mainPage.personalAccountButtonClick();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.exitButtonClick();
        loginPage.waitEnterButtonVisibility();

        MatcherAssert.assertThat("Выход не выполнен",
                loginPage.checkEnterText(),
                containsString("Вход"));

    }

}
