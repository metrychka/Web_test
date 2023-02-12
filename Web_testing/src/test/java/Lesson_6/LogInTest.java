package Lesson_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogInTest extends AbstractTest{

   @Test
    void LoginIn() {

       new  LoginPage(getWebDriver())
               .CButton()
               .setLogin("Che-bu-rachka")
               .setPassword("Ljvfiytt_pflfybt")
               .clickButton();
    }



}
