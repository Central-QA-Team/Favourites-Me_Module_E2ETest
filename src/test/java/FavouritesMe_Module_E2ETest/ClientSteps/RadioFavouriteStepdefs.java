package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Helper.HelperMethods;
import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.RadioFavourite;
import FavouritesMe_Module_E2ETest.pageObject.RadioMeModule;
import FavouritesMe_Module_E2ETest.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import org.json.JSONObject;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by patilk01 on 14/07/2015.
 */
public class RadioFavouriteStepdefs extends WebNavPage {

    RadioFavourite radioFav=new RadioFavourite();
    RadioMeModule radioMeModule = new RadioMeModule();
    public String clipTitle = null;
    boolean ifNext = false;
    Response metadata= null;
    public JSONObject jsonObj = new JSONObject();

    private RadioFavourite radioFavourite = new RadioFavourite();
    @When("^I add brand to Favourite$")
    public void I_add_brand_to_Favourite() throws Throwable {
        radioFav.I_find_a_brand();
        if(getText(radioFav.getFavouriteButtonLabel).toLowerCase().contains("Added to Favourites".toLowerCase())) {
            clickALink(radioFav.favouriteButton);
            waitForShortSpan();
        }
        clickALink(radioFav.favouriteButton);

    }

    @When("^I add episode to Favourite$")
    public void I_add_episode_to_Favourite() throws Throwable {
        radioFav.I_find_an_episode();
        waitForShortSpan();
        if(getText(radioFav.getFavouriteButtonLabel).toLowerCase().contains("Added to Favourites".toLowerCase())) {
            clickALink(radioFav.favouriteButton);
            waitForShortSpan();
        }

        clickALink(radioFav.favouriteButton);
    }

    @When("^I add clip to Favourite$")
    public void I_add_clip_to_Favourite() throws Throwable {
        radioFav.I_find_an_clip();
        if(getText(radioFav.getFavouriteButtonLabel).toLowerCase().contains("Added to Favourites".toLowerCase())) {
            clickALink(radioFav.favouriteButton);
            waitForShortSpan();
        }
        clipTitle = getPropertyOfElement(radioFav.favouriteButton,"title");
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

    @When("^I remove clip from Favourite$")
    public void I_remove_clip_from_Favourite() throws Throwable {
        if(!getText(radioFav.favouriteButton).toLowerCase().contains("Added to Favourites".toLowerCase())) {
            clickALink(radioFav.favouriteButton);
            waitForShortSpan();
        }
        clickALink(radioFav.favouriteButton);
    }


    @Then("^Favourite button should be in added state$")
    public void Favourite_button_should_be_in_added_state() throws Throwable {
        waitUntilElementIsVisible(radioFav.favouriteAddedButton);
        //waitUntilElementIsVisible(radioFav.addedFavouriteButtonStatus);
        waitForShortSpan();
        assertContentExists(radioFav.getFavouriteButtonLabel, "Added to Favourites");
        //Assert.assertEquals(true, elementExists(radioFav.addedFavouriteButtonStatus));

    }


    @Then("^brand button should change to Add state$")
    public void brand_button_should_change_to_Add_state() throws Throwable {
        waitForShortSpan();
        assertContentExists(radioFav.getFavouriteButtonLabel, "Add " + "\"" + radioFav.brand + "\"" + " to Favourites");

    }

    @Then("^favourite button for episode should change to Add state$")
    public void favourite_button_for_episode_should_change_to_Add_state() throws Throwable {
        waitForShortSpan();
        waitUntilElementIsVisible(By.xpath("//.[contains(text(),'"+radioFav.episodeTitle+"')]"));
        waitForShortSpan();
        assertContentExists(radioFav.getFavouriteButtonLabel, radioFav.episodeTitle);

    }

    @When("^favourite button for clip should change to Add state$")
    public void favourite_button_for_clip_should_change_to_Add_state() throws Throwable {
        waitForShortSpan();
        waitUntilElementIsVisible(By.xpath("//.[contains(text(),'" + clipTitle + "')]"));
        waitForShortSpan();
        assertContentExists(radioFav.getFavouriteButtonLabel, clipTitle);
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

    @Then("^I can find the clip on radio me module$")
    public void I_can_find_the_clip_on_radio_me_module() throws Throwable {
        clickALink(radioFav.yourFavourites);
        clickALink(radioFav.episodesNClips);
        boolean flag = false;
        do {
            if (elementExists(By.xpath("//li[@data-id='"+radioFav.clipPID+"']"))) {
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

    @Then("^I should not find the brand on radio me module$")
    public void I_should_not_find_the_brand_on_radio_me_module() throws Throwable {
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

    @Then("^I should not find clip on radio me module$")
    public void I_should_not_find_clip_on_radio_me_module() throws Throwable {
        boolean flag = false;
        clickALink(radioFav.yourFavourites);
        do {
            if (elementExists(By.xpath("//li[@data-id='"+ radioFav.clipPID +"']"))) {
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


    @Then("^I can remove the episode from Favourites on Radio Me Module$")
    public void I_can_remove_the_episode_from_Favourites_on_Radio_Me_Module() throws Throwable {
        waitForShortSpan();
        clickALink(By.xpath("//li[@data-id='" + radioFav.episodePID + "']/div/a"));
        clickALink(By.xpath("//li[@data-id='" + radioFav.episodePID + "']/div/span/span[1]/a"));
        clickALink(By.xpath("//li[@data-id='" + radioFav.episodePID + "']/div/span/span[2]/a[1]"));
        waitForShortSpan();
        assertFalse("True if brand is not present", elementExists(By.xpath("//li[@data-id='" + radioFav.episodePID + "']")));
    }

    @Then("^I can remove the clip from Favourites on Radio Me Module$")
    public void I_can_remove_the_clip_from_Favourites_on_Radio_Me_Module() throws Throwable {
        waitForShortSpan();
        clickALink(By.xpath("//li[@data-id='" + radioFav.clipPID + "']/div/a"));
        clickALink(By.xpath("//li[@data-id='" + radioFav.clipPID + "']/div/span/span[1]/a"));
        clickALink(By.xpath("//li[@data-id='" + radioFav.clipPID + "']/div/span/span[2]/a[1]"));
        waitForShortSpan();
        assertFalse("True if brand is not present", elementExists(By.xpath("//li[@data-id='" + radioFav.clipPID + "']")));
    }


    @When("^I navigate to brand page$")
    public void I_navigate_to_brand_page() throws Throwable {
        openWebPage(System.getProperty("baseUrl") + "/programmes/" + radioFav.brandPID);
    }

    @Then("^I navigate back to episode page$")
    public void I_navigate_back_to_episode_page() throws Throwable {
        openWebPage(System.getProperty("baseUrl") + "/programmes/" + radioFav.episodePID);
    }

    @When("^Navigate back to clip page$")
    public void Navigate_back_to_clip_page() throws Throwable {
        openWebPage(System.getProperty("baseUrl") + "/programmes/" + radioFav.clipPID);
    }


    @Then("^I can verify brand metadata as per available episodes")
    public void I_can_verify_brand_metadata_as_per_available_episodes() throws Throwable {
        RestAssured.appendURL("/my/content/meta/radio/tlec/" + radioFav.brandPID + "/newItems?key=3irk89d66");
        RestAssured.performGetRequest();
        String apiStartDate = null;
        String uiStartDate = null;
        String apiDuration = null;
        String uiDuration = null;
        metadata = RestAssured.getResponse();
        jsonObj = new JSONObject(metadata.asString());

        if(Integer.parseInt(jsonObj.get("total").toString())==0){
            Assert.assertEquals("Brand PID ",jsonObj.get("@id"),radioFav.brandPID);

        } else {
            Assert.assertEquals("Brand PID ",jsonObj.get("@id"),radioFav.brandPID);
            //Assert.assertEquals(jsonObj.getJSONArray("episodes").getJSONObject(0).get("image").toString(),getPropertyOfElement(By.xpath("//li[@data-id='" + radioFav.brandPID + "']//span[@class='my-block-one']/img"), "src"));
            try{
                Assert.assertEquals("Brand Series Title ",jsonObj.getJSONArray("episodes").getJSONObject(0).getJSONObject("partOfSeries").get("name"),getText(By.xpath("//li[@data-id='" + radioFav.brandPID + "']//span[@class='my-episode-brand']")));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            try {
                Assert.assertEquals("Brand Series Title ", jsonObj.getJSONArray("episodes").getJSONObject(0).getJSONObject("partOfBrand").get("name"), getText(By.xpath("//li[@data-id='" + radioFav.brandPID + "']//span[@class='my-episode-series']")));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            Assert.assertEquals("Episode Title ",jsonObj.getJSONArray("episodes").getJSONObject(0).get("name"),getText(By.xpath("//li[@data-id='"+radioFav.brandPID+"']//span[@class='my-episode']")));
            Assert.assertEquals("Description ",jsonObj.getJSONArray("episodes").getJSONObject(0).get("description"),getText(By.xpath("//li[@data-id='" + radioFav.brandPID + "']//span[@class='my-item-info']/p")));
            Assert.assertEquals("Network ",jsonObj.getJSONArray("episodes").getJSONObject(0).getJSONObject("publication").getJSONObject("broadcast").getJSONObject("publishedOn").get("name")+".",getText(By.xpath("//li[@data-id='"+radioFav.brandPID+"']//span[@class='my-episode-broadcaster']")));

            apiStartDate = jsonObj.getJSONArray("episodes").getJSONObject(0).getJSONObject("publication").getJSONObject("broadcast").getJSONObject("startDate").get("datetime").toString();
            uiStartDate = getText(By.xpath("//li[@data-id='" + radioFav.brandPID + "']//span[@class='my-episode-date my-episode-date-stamp']"));
            Assert.assertEquals("Date of Broadcast ", HelperMethods.getDate_d_M_y(apiStartDate.split("T")[0]), uiStartDate.substring(uiStartDate.indexOf(",") + 2));

            apiDuration = jsonObj.getJSONArray("episodes").getJSONObject(0).get("duration").toString();
            uiDuration = getText(By.xpath("//li[@data-id='" + radioFav.brandPID + "']//span[@class='my-episode-date']"));
            Assert.assertEquals("Duration ", HelperMethods.getMinutes(apiDuration),uiDuration.split(" ")[1]);


        }

    }

}
