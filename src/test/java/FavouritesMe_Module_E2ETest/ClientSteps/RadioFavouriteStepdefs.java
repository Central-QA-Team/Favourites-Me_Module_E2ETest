package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.RadioFavourite;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.WeakHashMap;

/**
 * Created by patilk01 on 14/07/2015.
 */
public class RadioFavouriteStepdefs extends WebNavPage {

    private RadioFavourite radioFavourite = new RadioFavourite();

    @Given("^I am on Radio homepage$")
    public void I_am_on_Radio_homepage() throws Throwable {
        String url=System.getProperty("baseUrl")+"/radio";
        openWebPage(url);
    }

//    @When("^I add recipe to Favourite")
//    public void I_add_recipe_to_Favourite() throws Throwable {
//        radioFavourite.I_find_a_recipe();
//        if(getText(radioFavourite.favouriteButton).toLowerCase().contains("Added to Favourites".toLowerCase())) {
//            clickALink(radioFavourite.favouriteButton);
//            waitForShortSpan();
//            clickALink(radioFavourite.favouriteButton);
//        }
//        else clickALink(radioFavourite.favouriteButton);
//    }

}
