package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.RadioFavourite;
import FavouritesMe_Module_E2ETest.pageObject.RadioMeModule;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import java.util.WeakHashMap;

/**
 * Created by patilk01 on 14/07/2015.
 */
public class RadioFavouriteStepdefs extends WebNavPage {

    RadioFavourite radioFav=new RadioFavourite();
    RadioMeModule radioMeModule = new RadioMeModule();
    public String brandName = null;

    private RadioFavourite radioFavourite = new RadioFavourite();
    @When("^I add brand to Favourite$")
    public void I_add_brand_to_Favourite() throws Throwable {
        radioFav.I_find_a_brand();
        brandName = getText(radioFav.brandName);

        if(getText(radioFav.addFavouriteButtonStatus).equalsIgnoreCase("Remove")) {
            clickALink(radioFav.favouriteButton);
            waitForShortSpan();
            clickALink(radioFav.favouriteButton);
        }
        else clickALink(radioFav.favouriteButton);;
        // clickALink(radioFav.favouriteButton);
        waitForShortSpan();
        waitForShortSpan();
    }


    @Then("^Add button should change to remove state$")
    public void Add_button_should_change_to_remove_state() throws Throwable {
        waitForShortSpan();
        assertContentExists(radioFav.addFavouriteButtonStatus, "Remove");
    }


    @Then("^I can find  the brand on radio me module$")
    public void I_can_find_the_recipe_on_radio_me_module() throws Throwable {
        clickALink(radioFav.yourFavourites);
        textBelongsToWebElementList(radioMeModule.favouriteBrandList, brandName);

    }


    @Then("^I can remove the brand from Favourites on Radio Me Module$")
    public void I_can_remove_the_brand_from_Favourites_on_Radio_Me_Module() throws Throwable {
        waitForShortSpan();
        clickALink(By.xpath("//li/span//span[1]/span[text()='" + brandName + "']/ancestor::li[@class='my-item']/div[@class='my-a-p my-a-p-default']"));
        clickALink(By.xpath("//li/span/span/a/span[2]/span[1]/span[1]/span[text()='"+brandName+"']/ancestor::li[@class='my-item']/div[@class='my-a-p my-a-p-expanded']//span[@class='my-a-p-actions']"));
        clickALink(By.xpath("//li/span/span/a/span[2]/span[1]/span[1]/span[text()='"+brandName+"']/ancestor::li[@class='my-item']/div[@class='my-a-p my-a-p-expanded']//span[@class='my-a-p-actions']/span[2]/a/span[text()='Yes']"));
        ///span/a[@class='my-a-p-button-remove']
    }

}
