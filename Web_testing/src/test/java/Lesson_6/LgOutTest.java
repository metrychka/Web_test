package Lesson_6;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LgOutTest extends AbstractTest {
    @Test
    void LogOut() throws InterruptedException {
        new  LoginPage(getWebDriver())
                .CButton()
                .setLogin("Che-bu-rachka")
                .setPassword("Ljvfiytt_pflfybt")
                .clickButton();

        Thread.sleep(4000);

       new  LoginPage(getWebDriver())
               .logOut();
         String actualUrl="https://www.livejournal.com/";
         String expectedUrl= getWebDriver().getCurrentUrl();
         Assert.assertEquals(expectedUrl,actualUrl);


    }
}
