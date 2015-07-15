package FavouritesMe_Module_E2ETest.pageObject;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by patilk01 on 15/07/2015.
 */
public class RadioFavourite extends WebNavPage{

    public String episode=null;

    //public By quickRecipeFinderSearch = By.id("search-keywords");
    //public By quickRecipeFinderSearchButton = By.id("search-submit");
    public By mostPopularProgramme = By.xpath(".//ul[@class='popular-list typical-list cf']/li[1][@class='episode']/div[1]/a");
    public By favouriteButton = By.xpath("//*[@id='pf1']/span[@id='pfl1']");
    public By yourFavourites = By.xpath("//a[@title='See Favourite items']");
    public By favouriteButtonStatus = By.xpath("//*[@id='pf1']/span/span[2]");

//    public void I_find_a_recipe() throws Throwable {
//        episode=getText(mostPopularProgramme);
//        clickALink(mostPopularProgramme);
//    }

}
