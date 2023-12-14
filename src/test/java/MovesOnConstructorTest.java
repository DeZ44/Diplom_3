import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import po.MainPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class MovesOnConstructorTest extends BaseTest {

    MainPage mainPage;

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }

    @Test
    public void checkSauceButton() {
        mainPage.sauceButtonClick();
        String actual = mainPage.getSauceButtonClass();
        String expected = "tab_tab_type_current__2BEPc";

        MatcherAssert.assertThat("Класс в кнопке не найден",
                actual,
                containsString(expected));
    }

    @Test
    public void checkFillingButton() {
        mainPage.fillingButtonClick();
        String actual = mainPage.getFillingButtonClass();
        String expected = "tab_tab_type_current__2BEPc";

        MatcherAssert.assertThat("Класс в кнопке не найден",
                actual,
                containsString(expected));
    }

    @Test
    public void checkBunsButton() {
        mainPage.fillingButtonClick();
        mainPage.bunsButtonClick();
        String actual = mainPage.getBunsButtonClass();
        String expected = "tab_tab_type_current__2BEPc";

        MatcherAssert.assertThat("Класс в кнопке не найден",
                actual,
                containsString(expected));
    }
}
