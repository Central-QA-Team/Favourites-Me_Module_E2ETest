package FavouritesMe_Module_E2ETest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static FavouritesMe_Module_E2ETest.SharedDriver.getDriver;

/**
 * Created by patilk01 on 24/06/2015.
 */
public class MeModuleCommonControls {

    private static WebElement element = null;

    By benefitOne = By.xpath(".//*[@class='my-benefits-list']/li[1]");
    By benefitTwo = By.xpath(".//*[@class='my-benefits-list']/li[2]");
    By benefitThree = By.xpath(".//*[@class='my-benefits-list']/li[3]");
    By benefitImage = By.xpath(".//*[@class='my-icon-benefits']");

    public WebElement benefitOne(){
        element = getDriver().findElement(benefitOne);
        return element;
    }

    public WebElement benefitTwo(){
        element = getDriver().findElement(benefitTwo);
        return element;
    }

    public WebElement benefitThree(){
        element = getDriver().findElement(benefitThree);
        return element;
    }

    public WebElement benefitImage(){
        element = getDriver().findElement(benefitImage);
        return element;
    }

}
