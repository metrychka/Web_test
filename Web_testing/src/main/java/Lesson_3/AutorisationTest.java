package Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutorisationTest {
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


    }
}
