package Lesson_6;

import org.junit.jupiter.api.Test;

public class SettingsLangTest extends AbstractTest {
    @Test
    void SetLangTest() throws InterruptedException {
        new  LoginPage(getWebDriver())
                .CButton()
                .setLogin("Che-bu-rachka")
                .setPassword("Ljvfiytt_pflfybt")
                .clickButton();

        Thread.sleep(3000);

      new LoginPage(getWebDriver())
              .setLang();


    }

}
