package Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SettingsLang {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.livejournal.com/");

        WebElement webElement1 = driver.findElement(By.xpath("//a[contains(@class,'s-header-item__link--login')]"));
        webElement1.click();
        WebElement login = driver.findElement(By.id("user"));
        login.sendKeys("Che-bu-rachka");
        WebElement password = driver.findElement(By.xpath("//*[@id='lj_loginwidget_password']"));
        password.sendKeys("Ljvfiytt_pflfybt");
        WebElement buttonAutoris = driver.findElement(By.xpath("//*[@name='action:login']"));
        buttonAutoris.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement logButton = driver.findElement(By.xpath("//span[contains(@class,'s-nav-item__name')]"));
        new Actions(driver).clickAndHold(logButton).perform();

        WebElement settings = driver.findElement(By.xpath("//a[contains(@class,'s-header-sub-list-item__link--settings')]"));
        settings.click();

        WebElement view = driver.findElement(By.xpath("//ul[@id='settings_nav']/li[3]/a"));
        view.click();

        WebElement lang = driver.findElement(By.id("LJ__Setting__Language_lang"));
        lang.click();

        WebElement selectLang = driver.findElement(By.xpath("//select[@id='LJ__Setting__Language_lang']"));
        Select select = new Select(selectLang);
        select.selectByVisibleText("English");

        WebElement buttonLang = driver.findElement(By.xpath("//*[@id='settings_save']/button"));
        buttonLang.click();







    }
}
