package FavouritesMe_Module_E2ETest.pageObject;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by patilk01 on 24/06/2015.
 */
public class MeModuleCommonControls extends WebNavPage{

    public By benefitOne = By.xpath(".//*[@class='my-benefits-list']/li[1]");
    public By benefitTwo = By.xpath(".//*[@class='my-benefits-list']/li[2]");
    public By benefitThree = By.xpath(".//*[@class='my-benefits-list']/li[3]");
    public By benefitImage = By.xpath(".//*[@class='my-icon-benefits']");
    public By firstItemInList = By.xpath(".//ol[@class='my-item-list ']/li[1]");
    public By clickableTileInMeModule = By.xpath(".//ol[@class='my-item-list ']/li[1]/span/span/a");
    public By favouritesPerPage = By.xpath(".//*[@class='my-item-list ']/li");

    public boolean verifyBenefitsPageContents(String arg1) {

        String[] array = arg1.split(",");
        return assertIfTwoTextsEqual(array[0],getText(benefitOne)) && assertIfTwoTextsEqual(array[1],getText(benefitTwo)) && assertIfTwoTextsEqual(array[2], getText(benefitThree)) && elementIsVisible(benefitImage);
    }

    public int getFavouriteListPerPage() {
        int totalItems = getWebElements(favouritesPerPage).size();
        return totalItems;
    }


}
