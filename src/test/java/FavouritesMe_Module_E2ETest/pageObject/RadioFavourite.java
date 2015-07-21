package FavouritesMe_Module_E2ETest.pageObject;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by patilk01 on 15/07/2015.
 */
public class RadioFavourite extends WebNavPage{

    //public String episode=null;

    //public By mostPopularProgramme = By.xpath(".//ul[@class='popular-list typical-list cf']/li[1][@class='episode']/div[1]/a");
    public By favouriteButton = By.id("pf1");
    public By yourFavourites = By.xpath("//*[@id='rsn-wrap']//li/a[text()='Favourites']");
    public By addFavouriteButtonStatus = By.xpath("//*[@id='pf1']/span[@class='p-f-label-display p-f-show']/span[2]");
    public By categories = By.xpath("//a/span[text()='Categories']");
    public By secondCategory = By.xpath("//ul/li[2]/a/div/h3");
    public By firstBrand = By.xpath("//div[2]/div/ol/li[1]//h4/a/span/span");
    public By brandName = By.xpath("//*[@id='br-masthead']/div/div[1]/div[2]/a/div");
    public By brandsFromCategoryFirstPage = By.xpath("//ol/li/div/div[2]/h4/a/span/span");



    public void I_find_a_brand() throws Throwable {
        clickALink(categories);
        clickALink(secondCategory);
        int randomNo = HelperMethods.randomNumber(1,getWebElements(brandsFromCategoryFirstPage).size());
        clickALink(By.xpath("//ol/li["+randomNo+"]/div/div[2]/h4/a/span/span"));
    }


}
