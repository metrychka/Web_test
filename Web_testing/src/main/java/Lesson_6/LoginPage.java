package Lesson_6;

import dev.failsafe.internal.util.Assert;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends AbstractPage {

    private static WebDriver driver;
    @FindBy(xpath = "//a[contains(@class,'s-header-item__link--login')]")
    private WebElement login;

    @FindBy(xpath = "//*[@id='lj_loginwidget_password']")
    private WebElement password;

    @FindBy(id = "user")
    private WebElement user;

    @FindBy(xpath = "//*[@name='action:login']")
    private WebElement submit;

    @FindBy(xpath = "//span[contains(@class,'s-nav-item__name')]")
    private WebElement accout;

    @FindBy(xpath = "//a[contains(@class, 's-header-sub-list-item__link--logout')]")
    private WebElement exit;

    @FindBy(xpath = "//a[contains(@class,'s-header-sub-list-item__link--settings')]")
    private WebElement settings;

    @FindBy(xpath = "//ul[@id='settings_nav']/li[3]/a")
    private WebElement settings_nav;

    @FindBy(id = "LJ__Setting__Language_lang")
    private WebElement language;

    @FindBy(xpath = "//*[@id='settings_save']/button")
    private WebElement set_button;



    public LoginPage(WebDriver driver){

        super(driver);
    }

    public void loginIn(){
        this.login.click();
    }

    public LoginPage CButton() {
        this.login.click();
        return this;
    }
    public LoginPage setLogin(String login){
        this.user.sendKeys(login);
        return this;
    }

    public LoginPage ClicKlLogin() {
        this.login.click();
        return this;

    }
    public LoginPage setPassword(String password){
        this.password.click();
        this.password.sendKeys(password);
        return this;
    }

    public LoginPage clickButton() {
        this.submit.click();
        return this;
    }


    public  void loginIn(String login, String password){

        Actions loginIn = new Actions(getDriver());
        loginIn
                .sendKeys(this.user,login)
                .click(this.password)
                .sendKeys(password)
                //.click(this.submit)
                .build()
                .perform();
    }

    public void logOut(){
        Actions logOut = new Actions(getDriver());
        logOut
                .clickAndHold(this.accout)
                .pause(1000)
                .click(this.exit)
                .build()
                .perform();

    }

    public void setLang() {
        Actions  setLang = new Actions(getDriver());
        setLang
                .clickAndHold(this.accout)
                .pause(3000)
                .click(this.settings)
                .pause(3000)
               .click(this.settings_nav)
               .click(this.language)
                .build()
                .perform();

       WebElement selectLang = driver.findElement(By.xpath("//select[@id='LJ__Setting__Language_lang']"));
        Select select = new Select(selectLang);
        select.selectByVisibleText("English");

        setLang.click(this.set_button)
                .build()
                .perform();
    }


}
