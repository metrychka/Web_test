package Lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@href, 'https://www.livejournal.com/category/puteshestviya/')]")
    private WebElement zdorovie;


    @FindBy (xpath = "//*[@class='search__control']")
    private WebElement category;

    @FindBy (xpath = "//*[@class='svgicon flaticon flaticon--search-2']")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }


     public MainPage setCategoty(String categoty) {
         this.zdorovie.click();
         this.category.sendKeys(categoty);
         return this;
     }

     public MainPage setSearch() {
        this.searchButton.click();
        return this;
     }


}
