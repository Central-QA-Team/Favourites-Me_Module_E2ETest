package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.RadioFavourite;
import FavouritesMe_Module_E2ETest.pageObject.RadioMeModule;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by patilk01 on 14/07/2015.
 */
public class RadioFavouriteStepdefs extends WebNavPage {

    RadioFavourite radioFav=new RadioFavourite();
    RadioMeModule radioMeModule = new RadioMeModule();
    public String brandPID = null;
    boolean ifNext = false;

    private RadioFavourite radioFavourite = new RadioFavourite();
    @When("^I add brand to Favourite$")
    public void I_add_brand_to_Favourite() throws Throwable {
        radioFav.I_find_a_brand();
        brandPID = currentURL().split("/")[4];
        if(getText(radioFav.getFavouriteButtonLabel).toLowerCase().contains("Added to Favourites".toLowerCase())) {
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


    @When("^I remove episode from Favourite$")
    public void I_remove_episode_from_Favourite() throws Throwable {
        if(!getText(radioFav.favouriteButton).toLowerCase().contains("Added to Favourites".toLowerCase())) {
            clickALink(radioFav.favouriteButton);
            waitForShortSpan();
        }
        clickALink(radioFav.favouriteButton);
    }


    @Then("^Add button should change to added state$")
    public void Add_button_should_change_to_added_state() throws Throwable {
        waitUntilElementIsVisible(radioFav.favouriteAddedButton);
        waitForShortSpan();
        assertContentExists(radioFav.getFavouriteButtonLabel, "Added to Favourites");
    }


    @Then("^status of brand favourite button should be added$")
    public void status_of_favourite_button_should_be_added() throws Throwable {
        waitForShortSpan();
        waitUntilElementIsVisible(radioFav.favouriteAddedButton);
        assertContentExists(radioFav.getFavouriteButtonLabel, "Added to Favourites");
    }


    @Then("^brand button should change to Add state$")
    public void brand_button_should_change_to_Add_state() throws Throwable {
        waitForShortSpan();
        assertContentExists(radioFav.getFavouriteButtonLabel, "Add " + "\"" + radioFav.brand + "\"" + " to Favourites");

    }


    @Then("^I can find the brand on radio me module$")
    public void I_can_find_the_brand_on_radio_me_module() throws Throwable {
        boolean flag = false;
        clickALink(radioFav.yourFavourites);
        do {
            if (elementExists(By.xpath("//li[@data-id='"+ radioFav.brandPID +"']"))) {
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
            if (elementExists(By.xpath("//li[@data-id='"+ brandPID +"']"))) {
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



    @Then("^I should not find episode on radio me module$")
    public void I_should_not_find_episode_on_radio_me_module() throws Throwable {
        boolean flag = false;
        clickALink(radioFav.yourFavourites);
        do {
            if (elementExists(By.xpath("//li[@data-id='"+ radioFav.episodePID +"']"))) {
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
        clickALink(By.xpath("//li[@data-id='" + radioFav.brandPID + "']/div/a"));
        clickALink(By.xpath("//li[@data-id='" + radioFav.brandPID + "']/div/span/span[1]/a"));
        clickALink(By.xpath("//li[@data-id='" + radioFav.brandPID + "']/div/span/span[2]/a[1]"));
        waitForShortSpan();
        assertFalse("True if brand is not present", elementExists(By.xpath("//li[@data-id='" + radioFav.brandPID + "']")));
    }


    @When("^I navigate to brand page$")
    public void I_navigate_to_brand_page() throws Throwable {
        openWebPage(System.getProperty("baseUrl") + "/programmes/" + radioFav.brandPID);
    }


    @When("^I add episode to Favourite$")
    public void I_add_episode_to_Favourite() throws Throwable {
        radioFav.I_find_an_episode();
        if(getText(radioFav.getFavouriteButtonLabel).toLowerCase().contains("Added to Favourites".toLowerCase())) {
            clickALink(radioFav.favouriteButton);
            waitForShortSpan();
        }

        clickALink(radioFav.favouriteButton);
    }


    @Then("^favourite button for episode should change to added state$")
    public void favourite_button_for_episode_should_change_to_added_state() throws Throwable {
        waitUntilElementIsVisible(radioFav.favouriteAddedButton);
        waitForShortSpan();
        assertContentExists(radioFav.getFavouriteButtonLabel, "Added to Favourites");
    }


    @Then("^I can find the episode on radio me module$")
    public void I_can_find_the_episode_on_radio_me_module() throws Throwable {
        clickALink(radioFav.yourFavourites);
        clickALink(radioFav.episodesNClips);
        boolean flag = false;

        do {
            if (elementExists(By.xpath("//li[@data-id='"+radioFav.episodePID+"']"))) {
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
        assertTrue("True if Episode Present", flag);
    }

    @Then("^I can remove the episode from Favourites on Radio Me Module$")
    public void I_can_remove_the_episode_from_Favourites_on_Radio_Me_Module() throws Throwable {
        waitForShortSpan();
        clickALink(By.xpath("//li[@data-id='" + radioFav.episodePID + "']/div/a"));
        clickALink(By.xpath("//li[@data-id='" + radioFav.episodePID + "']/div/span/span[1]/a"));
        clickALink(By.xpath("//li[@data-id='" + radioFav.episodePID + "']/div/span/span[2]/a[1]"));
        waitForShortSpan();
        assertFalse("True if brand is not present", elementExists(By.xpath("//li[@data-id='" + radioFav.episodePID + "']")));
    }


    @Then("^I navigate back to episode page$")
    public void I_navigate_back_to_episode_page() throws Throwable {
        openWebPage(System.getProperty("baseUrl") + "/programmes/" + radioFav.episodePID);
    }


    @Then("^favourite button for episode should change to Add state$")
    public void favourite_button_for_episode_should_change_to_Add_state() throws Throwable {
        waitForShortSpan();
        waitUntilElementIsVisible(By.xpath("//.[contains(text(),'"+radioFav.episodeTitle+"')]"));
        waitForShortSpan();
        assertContentExists(radioFav.getFavouriteButtonLabel, radioFav.episodeTitle);

    }


}
