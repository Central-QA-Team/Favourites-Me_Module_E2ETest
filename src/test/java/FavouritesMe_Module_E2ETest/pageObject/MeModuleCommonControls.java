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
    public By actionPanel =By.xpath(".//li[1]/div/a");
    public By removeButton =By.xpath(".//li[1]/div/span/span[1]/a");
    public By actionPanelLabel = By.xpath(".//li[1]/div/span/span[2]/span");
    public By confirm = By.xpath(".//li[1]/div/span/span[2]/a[1]");
    public By cancle =By.xpath(".//li[1]/div/span/span[2]/a[2]");


    public boolean verifyBenefitsPageContents(String arg1) {

        String[] array = arg1.split(",");
        return assertIfTwoTextsEqual(array[0],getText(benefitOne)) && assertIfTwoTextsEqual(array[1],getText(benefitTwo)) && assertIfTwoTextsEqual(array[2], getText(benefitThree)) && elementIsVisible(benefitImage);
    }

    public int getFavouriteListPerPage() {
        int totalItems = getWebElements(favouritesPerPage).size();
        return totalItems;
    }

    public boolean verifyActionPanelContents(String arg1) {
        clickALink(actionPanel);
        clickALink(removeButton);
        String[] array = arg1.split(",");
        return assertIfTwoTextsEqual(array[0],getText(actionPanelLabel)) && assertIfTwoTextsEqual(array[1],getText(confirm)) && assertIfTwoTextsEqual(array[2], getText(cancle));
    }


}
