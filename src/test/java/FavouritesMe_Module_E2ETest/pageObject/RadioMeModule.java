package FavouritesMe_Module_E2ETest.pageObject;

import static FavouritesMe_Module_E2ETest.SharedDriver.getDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

/**
 * Created by patilk01 on 18/06/2015.
 */
public class RadioMeModule extends MeModuleCommonControls {


    private static WebElement element = null;

    public By programmeUpdate = By.xpath(".//*[@id='blq-content']/div/div[2]/div/div[2]/ul/li[1]/a");
    public By episodesClips = By.xpath(".//*[@id='blq-content']/div/div[2]/div/div[2]/ul/li[2]/a");
    public By cyLanguage = By.xpath(".//*[@id='network-language-select']/li[1]/a");
    public By gaLanguage = By.xpath(".//*[@id='network-language-select']/li[2]/a");
    public By gdLanguage = By.xpath(".//*[@id='network-language-select']/li[3]/a");
    public By tabDescription = By.xpath(".//*[@id='my-tabs-hint']");
    public By pageTitle = By.xpath(".//*[@class='hdr-inner radio-container']");
    public By emptyPageFirstLine = By.xpath(".//*[@class='my-text-1']");
    public By emptyPageSecondLine = By.xpath(".//*[@class='my-text-2']");
    public By emptyPageImage = By.xpath(".//*[@class='my-icon-signed-in-no-favourites']");
    public By firstBrandInList = By.xpath(".//ol[@class='my-item-list 1']/li[1]");
    public By clickableBrandInMeModule = By.xpath(".//ol[@class='my-item-list 1']/li[1]/span/span/a");
    public By favouriteBrandList = By.xpath("//li/span/span/a/span[2]/span[1]/span[1]/span");
    public By next = By.xpath("//*[@id='next']/a");
    public By moreItemsFromBrand = By.xpath(".//ol[@class='my-item-list 1']/li[1]//*[@class='my-more-items']");
    public By moreLinkNavigation = By.xpath(".//ol[@class='my-item-list 1']/li[1]//*[@class='my-more-items']/a");
}



