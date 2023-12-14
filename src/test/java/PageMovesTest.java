import org.hamcrest.MatcherAssert;
import org.junit.Test;
import po.PersonalAccountPage;

import static org.hamcrest.CoreMatchers.containsString;

public class PageMovesTest extends CreateAndLoginBaseTest {


    @Test
    public void checkOpenPersonalAccountPage() {
        mainPage.personalAccountButtonClick();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        MatcherAssert.assertThat("В личный кабинет не перешли",
                personalAccountPage.getTextFromNameField(),
                containsString(name));

    }

    @Test
    public void checkMoveFromPersonalAccountPageToBuilder() {
        mainPage.personalAccountButtonClick();
        mainPage.builderButtonClick();

        MatcherAssert.assertThat("Переход на страницу не осуществлён",
                mainPage.checkTitleMainPage(),
                containsString("Соберите бургер"));

    }

    @Test
    public void checkMoveFromPersonalAccountPageToLogo() {
        mainPage.personalAccountButtonClick();
        mainPage.logoButtonClick();

        MatcherAssert.assertThat("Переход на страницу не осуществлён",
                mainPage.checkTitleMainPage(),
                containsString("Соберите бургер"));

    }

}
