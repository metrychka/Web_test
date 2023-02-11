package Lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class HomeWorkTest {
    private static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.livejournal.com/");
    }

   /* @AfterAll
    static void close(){
        driver.quit();
    }*/

    @Test
    void AuthorisationTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//a[contains(@class,'s-header-item__link--login')]")))
                .sendKeys(driver.findElement(By.id("user")),"Che-bu-rachka")
                .sendKeys(driver.findElement(By.xpath("//*[@id='lj_loginwidget_password']")),"Ljvfiytt_pflfybt")
                .click(driver.findElement(By.xpath("//*[@name='action:login']")))
                .build()
                .perform();
       String actualUrl="https://www.livejournal.com/";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    void CategorySearchTest() throws InterruptedException {

        WebElement cetegory = driver.findElement(By.xpath("//a[contains(@href, 'https://www.livejournal.com/category/zdorove/')]"));
        cetegory.click();
        WebElement categorySearch = driver.findElement(By.xpath("//*[@class='search__control']"));
        categorySearch.sendKeys("гастрит");
        WebElement categoryButton = driver.findElement(By.xpath("//*[@class='svgicon flaticon flaticon--search-2']"));
        categoryButton.click();

        String actualUrl="https://www.livejournal.com/rsearch?q=%D0%B3%D0%B0%D1%81%D1%82%D1%80%D0%B8%D1%82&sort=_score&searchArea=byCategory&category=%D0%B7%D0%B4%D0%BE%D1%80%D0%BE%D0%B2%D1%8C%D0%B5";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }

    @Test
    void LegalOpenTest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//*[@class='main-footer__bottom-links-item']/a[1]")))
                .build()
                .perform();
      String actualUrl="https://help.rambler.ru/legal/1142/";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

     @Test
    void SettingsLangtest() throws InterruptedException {

       Actions actions = new Actions(driver);
         actions.click(driver.findElement(By.xpath("//a[contains(@class,'s-header-item__link--login')]")))
                 .sendKeys(driver.findElement(By.id("user")),"Che-bu-rachka")
                 .sendKeys(driver.findElement(By.xpath("//*[@id='lj_loginwidget_password']")),"Ljvfiytt_pflfybt")
                 .click(driver.findElement(By.xpath("//*[@name='action:login']")))
                 .build()
                 .perform();

         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

       actions.clickAndHold(driver.findElement(By.xpath("//span[contains(@class,'s-nav-item__name')]")))
                .build()
                .perform();

         Thread.sleep(3000);

       actions.click(driver.findElement(By.xpath("//a[contains(@class,'s-header-sub-list-item__link--settings')]")))
          .build()
          .perform();

       actions.click(driver.findElement(By.xpath("//ul[@id='settings_nav']/li[3]/a")))
              .build()
              .perform();

       actions.click(driver.findElement(By.id("LJ__Setting__Language_lang")))
               .build()
               .perform();

        WebElement selectLang = driver.findElement(By.xpath("//select[@id='LJ__Setting__Language_lang']"));
         Select select = new Select(selectLang);
         select.selectByVisibleText("English");

         actions.click(driver.findElement(By.xpath("//*[@id='settings_save']/button")))
                 .build()
                 .perform();

         String actualUrl="https://www.livejournal.com/manage/settings/?cat=display&saved=1";
         String expectedUrl= driver.getCurrentUrl();
         Assert.assertEquals(expectedUrl,actualUrl);
     }

     @Test
     void LogOutTest() throws InterruptedException {
         Actions actions = new Actions(driver);
         actions.click(driver.findElement(By.xpath("//a[contains(@class,'s-header-item__link--login')]")))
                 .sendKeys(driver.findElement(By.id("user")),"Che-bu-rachka")
                 .sendKeys(driver.findElement(By.xpath("//*[@id='lj_loginwidget_password']")),"Ljvfiytt_pflfybt")
                 .click(driver.findElement(By.xpath("//*[@name='action:login']")))
                 .build()
                 .perform();

         Thread.sleep(3000);

         actions.clickAndHold(driver.findElement(By.xpath("//span[contains(@class,'s-nav-item__name')]")))
                 .build()
                 .perform();

         Thread.sleep(3000);

         actions.click(driver.findElement(By.xpath("//a[contains(@class, 's-header-sub-list-item__link--logout')]")))
                 .build()
                 .perform();
         String actualUrl="https://www.livejournal.com/";
         String expectedUrl= driver.getCurrentUrl();
         Assert.assertEquals(expectedUrl,actualUrl);
     }

     @Test
     void PostTest() throws InterruptedException {
         Actions actions = new Actions(driver);
           actions.click(driver.findElement(By.xpath("//a[contains(@class,'s-header-item__link--login')]")))
                 .sendKeys(driver.findElement(By.id("user")),"Che-bu-rachka")
                 .sendKeys(driver.findElement(By.xpath("//*[@id='lj_loginwidget_password']")),"Ljvfiytt_pflfybt")
                 .click(driver.findElement(By.xpath("//*[@name='action:login']")))
                 .build()
                 .perform();

         Thread.sleep(3000);

         actions.click(driver.findElement(By.cssSelector(".s-header-item-post--long")))
                 .build()
                 .perform();

         actions.sendKeys(driver.findElement(By.cssSelector(".text-0-2-179")), "Заголовок теста")
                 .build()
                 .perform();

         actions.sendKeys(driver.findElement(By.cssSelector(".notranslate")), "публикация тестовая")
                 .build()
                 .perform();
         Thread.sleep(3000);

         actions.click(driver.findElement(By.cssSelector(".backgroundBlue-0-2-104 > .rootIn-0-2-98")))
                 .build()
                 .perform();
         Thread.sleep(3000);

         actions.click(driver.findElement(By.xpath("//button[contains(@class, 'reset-0-2-89 root-0-2-91 rootMaxWidth-0-2-99 textBold-0-2-102 textBlue-0-2-103')]")))
                 .build()
                 .perform();

         Thread.sleep(4000);

         Assertions.assertTrue(driver.getTitle().contains("Заголовок теста"), "публикации нет");

     }

}


