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

    public static String brand=null;
    public static String brandPID = null;
    public static String episodePID = null;
    public static String episodeTitle = null;
    public static String clipPID = null;


    //public By mostPopularProgramme = By.xpath(".//ul[@class='popular-list typical-list cf']/li[1][@class='episode']/div[1]/a");
    public By favouriteButton = By.cssSelector("#pf1");
    public By getFavouriteButtonLabel = By.xpath("//*[@id='pf1']/span[@id='pfl1']");
    public By yourFavourites = By.cssSelector(".rsn-favourites-link");
    public By addFavouriteButtonStatus = By.xpath("//*[@id='pf1']/span[@class='p-f-label-display p-f-show']/span[1]");
    public By categories = By.xpath("//a/span[text()='Categories']");
    public By secondCategory = By.xpath("//ul/li[2]/a/div/h3");
    public By firstBrand = By.xpath("//div[2]/div/ol/li[1]//h4/a/span/span");
    public By brandName = By.xpath("//*[@id='br-masthead']/div/div[1]/div[2]/a/div");
    public By brandsWithEpisodes = By.xpath("//li/div/div[2]/div/a/span/ancestor::div[@class='programme__body']/following-sibling::a");
    public By mostPopular = By.xpath("//a/span[text()='Most Popular']");
    public By mostPopularList = By.xpath("//li/div/a/h3");
    public By episodes = By.xpath("//*[@id='br-nav-programme']/ul[1]/li[2]/a");
    public By episodesAll = By.xpath("//*[@id='programmes-main-content']/div[2]/ul/li[1]/a");
    public By episodeList = By.xpath("//li/div/div/div/div/div/div[2]//a/span/span");
    public By episodesNClips = By.xpath("//ul[@class='my-tabs']/li[2]/a");
    public By favouriteAddedButton = By.xpath("//.[@id='pfl1'][contains(text(),'Added to Favourites')]");
    public By clipOnRadioHomePage = By.xpath("//li[@class='clip']//a");
    public By brandHome = By.xpath(".//*[@data-linktrack='nav_home']");




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
        clickALink(episodesAll);
        waitForShortSpan();
        randomNo = HelperMethods.randomNumber(getWebElements(episodeList).size());
        if(randomNo==getWebElements(episodeList).size())
            randomNo--;
        clickALink(By.xpath("//li["+randomNo+"]/div/div/div/div/div/div[2]//a/span/span"));
        episodePID = currentURL().split("/")[4];
        episodeTitle = getPropertyOfElement(favouriteButton,"title");
    }


    public void I_find_an_clip() throws Throwable {

        clickALink(clipOnRadioHomePage);
        waitForShortSpan();
        clipPID = currentURL().split("/")[4].split("#")[0];
        brandPID = getPropertyOfElement(brandHome, "href").substring(getPropertyOfElement(brandHome,"href").lastIndexOf('/') + 1);
    }



}
