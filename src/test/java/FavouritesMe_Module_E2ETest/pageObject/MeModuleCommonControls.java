package FavouritesMe_Module_E2ETest.pageObject;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static FavouritesMe_Module_E2ETest.SharedDriver.getDriver;

/**
 * Created by patilk01 on 24/06/2015.
 */
public class MeModuleCommonControls extends WebNavPage{

    public By benefitOne = By.xpath(".//*[@class='my-benefits-list']/li[1]");
    public By benefitTwo = By.xpath(".//*[@class='my-benefits-list']/li[2]");
    public By benefitThree = By.xpath(".//*[@class='my-benefits-list']/li[3]");
    public By benefitImage = By.xpath(".//*[@class='my-icon-benefits']");

    public boolean verifyBenefitsPageContents(String arg1) {

        String[] array = arg1.split(",");
        return assertIfTwoTextsEqual(array[0],getTextUsingBy(benefitOne)) && assertIfTwoTextsEqual(array[1],getTextUsingBy(benefitTwo)) && assertIfTwoTextsEqual(array[2], getTextUsingBy(benefitThree)) && elementIsVisibleUsingBy(benefitImage);
    }


}
