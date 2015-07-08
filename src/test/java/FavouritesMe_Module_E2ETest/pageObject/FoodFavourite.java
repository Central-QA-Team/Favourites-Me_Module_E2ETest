package FavouritesMe_Module_E2ETest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by khotd01 on 06/07/2015.
 */
public class FoodFavourite {
    private static WebElement element = null;

    public By quickRecipeFinderSearch = By.id("search-keywords");
    public By quickRecipeFinderSearchButton = By.id("search-submit");
    public By firstRecipeFromList = By.xpath("//*[@id='article-list']/ul/li[2]/div/h3/a");
    public By favouriteButton = By.xpath("//*[@id='pf1']/span[@id='pfl1']");
    public By yourFavourites = By.xpath("//a[@title='See Favourite items']");
    public By favouriteButtonStatus = By.xpath("//*[@id='pf1']/span/span[2]");

}
