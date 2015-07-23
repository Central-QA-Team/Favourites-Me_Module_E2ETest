package FavouritesMe_Module_E2ETest.pageObject;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.Helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by patilk01 on 15/07/2015.
 */
public class RadioFavourite extends WebNavPage{

    public String brand=null;
    public String brandPID = null;
    public String episodePID = null;
    public String episodeTitle = null;

    //public By mostPopularProgramme = By.xpath(".//ul[@class='popular-list typical-list cf']/li[1][@class='episode']/div[1]/a");
    public By favouriteButton = By.id("pf1");
    public By getFavouriteButtonLabel = By.xpath("//*[@id='pf1']/span[@id='pfl1']");
    public By yourFavourites = By.xpath("//*[@id='rsn-wrap']//li[4]/a");
    public By addFavouriteButtonStatus = By.xpath("//*[@id='pf1']/span[@class='p-f-label-display p-f-show']/span[1]");
    public By categories = By.xpath("//a/span[text()='Categories']");
    public By secondCategory = By.xpath("//ul/li[2]/a/div/h3");
    public By firstBrand = By.xpath("//div[2]/div/ol/li[1]//h4/a/span/span");
    public By brandName = By.xpath("//*[@id='br-masthead']/div/div[1]/div[2]/a/div");
    public By brandsWithEpisodes = By.xpath("//li/div/div[2]/div/a/span/ancestor::div[@class='programme__body']/following-sibling::a");
    public By mostPopular = By.xpath("//a/span[text()='Most Popular']");
    public By mostPopularList = By.xpath("//li/div/a/h3");
    public By episodes = By.xpath("//*[@id='br-nav-programme']/ul[1]/li[2]/a");
    public By episodesAvailableNow = By.xpath("//*[@id='programmes-main-content']/div[2]/ul/li[3]/a");
    public By episodeList = By.xpath("//li/div/div[2]/h4/a/span[1]/span");
    public By episodesNClips = By.xpath("//ul[@class='my-tabs']/li[2]/a");
    public By favouriteAddedButton = By.xpath("//.[@id='pfl1'][contains(text(),'Added to Favourites')]");




    public void I_find_a_brand() throws Throwable {
        clickALink(categories);
        clickALink(secondCategory);
        int randomNo;
            List<WebElement> webElements = getWebElements(brandsWithEpisodes);
            if(webElements.size()==1)
                randomNo = 1;
        else {
                randomNo = HelperMethods.randomNumber(webElements.size());
                webElements.get(randomNo).click();
                brand = getText(brandName);
                brandPID = currentURL().split("/")[4];
            }
    }

    public void I_find_an_episode() throws Throwable {
        int randomNo;
        I_find_a_brand();
        clickALink(episodes);
        waitForShortSpan();
        clickALink(episodesAvailableNow);
        randomNo = HelperMethods.randomNumber(getWebElements(episodeList).size());
        clickALink(By.xpath("//li["+randomNo+"]/div/div[2]/h4/a/span[1]/span"));
        episodePID = currentURL().split("/")[4];
        episodeTitle = getPropertyOfElement(favouriteButton,"title");
    }


}
