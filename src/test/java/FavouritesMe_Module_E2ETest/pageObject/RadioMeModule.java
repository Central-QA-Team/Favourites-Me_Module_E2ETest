package FavouritesMe_Module_E2ETest.pageObject;

import static FavouritesMe_Module_E2ETest.SharedDriver.getDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

/**
 * Created by patilk01 on 18/06/2015.
 */
public class RadioMeModule extends MeModuleCommonControls {


    private static WebElement element = null;

    By programmeUpdate = By.xpath(".//*[@id='blq-content']/div/div[2]/div/div[2]/ul/li[1]/a");
    By episodesClips = By.xpath(".//*[@id='blq-content']/div/div[2]/div/div[2]/ul/li[2]/a");
    By cyLanguage = By.xpath(".//*[@id='network-language-select']/li[1]/a");
    By gaLanguage = By.xpath(".//*[@id='network-language-select']/li[2]/a");
    By gdLanguage = By.xpath(".//*[@id='network-language-select']/li[3]/a");
    By tabDescription = By.xpath(".//*[@id='my-tabs-hint']");
    By pageTitle = By.xpath(".//*[@class='hdr-inner radio-container']");
    By emptyPageFirstLine = By.xpath(".//*[@class='my-text-1']");
    By emptyPageSecondLine = By.xpath(".//*[@class='my-text-2']");
    By emptyPageImage = By.xpath(".//*[@class='my-icon-signed-in-no-favourites']");

    public WebElement programmeUpdate(){
        element = getDriver().findElement(programmeUpdate);
        return element;
    }

    public WebElement episodesClips(){
        element = getDriver().findElement(episodesClips);
        return element;
    }

    public WebElement cyLanguage(){
        element = getDriver().findElement(cyLanguage);
        return element;
    }

    public WebElement gaLanguage(){
        element = getDriver().findElement(gaLanguage);
        return element;
    }

    public WebElement gdLanguage(){
        element = getDriver().findElement(gdLanguage);
        return element;
    }

    public WebElement tabDescription(){
        element = getDriver().findElement(tabDescription);
        return element;
    }

    public WebElement pageTitle(){
        element = getDriver().findElement(pageTitle);
        return element;
    }

    public WebElement emptyPageFirstLine(){
        element = getDriver().findElement(emptyPageFirstLine);
        return element;
    }

    public WebElement emptyPageSecondLine(){
        element = getDriver().findElement(emptyPageSecondLine);
        return element;
    }

    public WebElement emptyPageImage(){
        element = getDriver().findElement(emptyPageImage);
        return element;
    }



}



