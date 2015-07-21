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
import static org.junit.Assert.assertFalse;

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
        if(getText(radioFav.addFavouriteButtonStatus).toLowerCase().contains("Added to Favourites".toLowerCase())) {
            clickALink(radioFav.favouriteButton);
            waitForShortSpan();
        }
        clickALink(radioFav.favouriteButton);

    }

    @When("^I remove brand from Favourite$")
    public void I_remove_brand_from_Favourite() throws Throwable {
        radioFav.I_find_a_brand();
        if(!getText(radioFav.favouriteButton).toLowerCase().contains("Added to Favourites".toLowerCase())) {
            clickALink(radioFav.favouriteButton);
            waitForShortSpan();
        }
        clickALink(radioFav.favouriteButton);
    }



    @Then("^Add button should change to added state$")
    public void Add_button_should_change_to_added_state() throws Throwable {
        waitForShortSpan();
        assertContentExists(radioFav.getFavouriteButtonLabel, "Added to Favourites");
    }

    @Then("^brand button should change to Add state$")
    public void brand_button_should_change_to_Add_state() throws Throwable {
        waitForShortSpan();
        assertContentExists(radioFav.getFavouriteButtonLabel, "Add "+"\"" + radioFav.brand + "\"" + " to Favourites");
    }


    @Then("^I can find the brand on radio me module$")
    public void I_can_find_the_brand_on_radio_me_module() throws Throwable {
        boolean flag = false;
        clickALink(radioFav.yourFavourites);
        do {
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

    @Then("^I should not find the brand on radio me module$")
    public void I_should_not_find_the_brand_on_radio_me_module() throws Throwable {
        boolean flag = false;
        clickALink(radioFav.yourFavourites);
        do {
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
        assertFalse("True if Brand not Present", flag);

    }

    @Then("^I can remove the brand from Favourites on Radio Me Module$")
    public void I_can_remove_the_brand_from_Favourites_on_Radio_Me_Module() throws Throwable {
        waitForShortSpan();
        clickALink(By.xpath("//li[@data-id='" + brandId + "']/div/a"));
        clickALink(By.xpath("//li[@data-id='" + brandId + "']/div/span/span[1]/a"));
        clickALink(By.xpath("//li[@data-id='" + brandId + "']/div/span/span[2]/a[1]"));
        waitForShortSpan();
        assertFalse("True if brand is not present", elementExists(By.xpath("//li[@data-id='"+ brandId +"']")));
    }

    @When("^Navigate back to Brand page$")
    public void Navigate_back_to_Brand_page() throws Throwable {
        openWebPage(System.getProperty("baseUrl")+ "/programmes/" + brandId);
    }

}
