package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.RadioFavourite;
import FavouritesMe_Module_E2ETest.pageObject.RadioMeModule;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import java.util.WeakHashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by patilk01 on 14/07/2015.
 */
public class RadioFavouriteStepdefs extends WebNavPage {

    RadioFavourite radioFav=new RadioFavourite();
    RadioMeModule radioMeModule = new RadioMeModule();
    public String brandId = null;
    boolean ifNext = false;

    private RadioFavourite radioFavourite = new RadioFavourite();
    @When("^I add brand to Favourite$")
    public void I_add_brand_to_Favourite() throws Throwable {
        radioFav.I_find_a_brand();
        brandId = currentURL().split("/")[4];
        System.out.println(getText(radioFav.addFavouriteButtonStatus));
//        if(getText(radioFav.addFavouriteButtonStatus).toLowerCase().contains("Remove".toLowerCase())) {
//            By temp = radioFav.favouriteButton;
//            clickALink(radioFav.favouriteButton);
//            clickALink(temp);
//        }
//        else clickALink(radioFav.favouriteButton);
        clickALink(radioFav.favouriteButton);

    }


    @Then("^Add button should change to remove state$")
    public void Add_button_should_change_to_remove_state() throws Throwable {
        waitForShortSpan();
        assertContentExists(radioFav.addFavouriteButtonStatus, "Remove");
    }


    @Then("^I can find  the brand on radio me module$")
    public void I_can_find_the_recipe_on_radio_me_module() throws Throwable {
        boolean flag = false;
        //boolean ifNext = false;
        clickALink(radioFav.yourFavourites);
        do {
            //if (textBelongsToWebElementList(radioMeModule.favouriteBrandList, brandName)) {
            if (elementExists(By.xpath("//li[@data-id='"+brandId+"']"))) {
                flag = true;
                break;
            }
            else {
                ifNext = elementExists(radioMeModule.next);
                if(ifNext)
                    clickALink(radioMeModule.next);
            }
        }while (ifNext);
        waitForShortSpan();
        waitForShortSpan();
        assertTrue("True if Brand Present", flag);

    }


    @Then("^I can remove the brand from Favourites on Radio Me Module$")
    public void I_can_remove_the_brand_from_Favourites_on_Radio_Me_Module() throws Throwable {
        waitForShortSpan();
//        boolean ifNext = false;
//        do {
//            if (elementExists(By.xpath("//li[@data-id='" + brandId + "']"))) {
                clickALink(By.xpath("//li[@data-id='" + brandId + "']/div[@class='my-a-p my-a-p-default']/a"));
                clickALink(By.xpath("//li[@data-id='" + brandId + "']/div/span/a"));
                clickALink(By.xpath("//li[@data-id='" + brandId + "']/div/span/span[2]/a[1]"));
//                break;
//            }
//            else {
//                ifNext = elementExists(radioMeModule.next);
//                if(ifNext)
//                    clickALink(radioMeModule.next);
//            }
//        }while(ifNext);

    }

}
