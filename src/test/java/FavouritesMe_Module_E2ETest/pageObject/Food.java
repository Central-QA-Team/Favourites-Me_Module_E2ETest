package FavouritesMe_Module_E2ETest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by khotd01 on 06/07/2015.
 */
public class Food {
    private static WebElement element = null;

    public By quickRecipeFinderSearch = By.id("search-keywords");
    public By firstRecipeFromList = By.xpath("//*[@id='article-list']/ul/li[2]/div/h3/a");
    public By favouriteButton = By.id("pf1");
}
