package FavouritesMe_Module_E2ETest.pageObject;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by khotd01 on 06/07/2015.
 */
public class FoodFavourite extends WebNavPage{

    public String recipe=null;
    public String recipeDataID = null;

    public By quickRecipeFinderSearch = By.id("search-keywords");
    public By quickRecipeFinderSearchButton = By.id("search-submit");
    public By firstRecipeFromList = By.xpath("//*[@id='article-list']/ul/li[2]/div/h3/a");
    public By favouriteButton = By.xpath("//*[@id='pf1']/span[@id='pfl1']");
    public By yourFavourites = By.xpath("//a[@title='See Favourite items']");
    public By favouriteButtonStatus = By.xpath("//*[@id='pf1']/span/span[2]");

    public void I_find_a_recipe() throws Throwable {
        clearAnyField(quickRecipeFinderSearch);
        enterAnyTextInAField(quickRecipeFinderSearch,"salt");
        waitForShortSpan();
        clickALink(quickRecipeFinderSearchButton);
        recipe=getText(firstRecipeFromList);
        clickALink(firstRecipeFromList);
        recipeDataID =currentURL().split("/")[5];
    }


}
