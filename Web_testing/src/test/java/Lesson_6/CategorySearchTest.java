package Lesson_6;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class CategorySearchTest extends AbstractTest{
    @Test
    void Category() {
        new MainPage(getWebDriver())
                .setCategoty("Алтай")
                .setSearch();

        String actualUrl="https://www.livejournal.com/rsearch?q=%D0%90%D0%BB%D1%82%D0%B0%D0%B9&sort=_score&searchArea=byCategory&category=%D0%BF%D1%83%D1%82%D0%B5%D1%88%D0%B5%D1%81%D1%82%D0%B2%D0%B8%D1%8F";
        String expectedUrl= getWebDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);


    }
}
