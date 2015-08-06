package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import FavouritesMe_Module_E2ETest.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonArray;
import junit.framework.Assert;
import org.eclipse.jetty.util.ajax.JSON;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by patilk01 on 18/06/2015.
 */
public class RadioMeStepdefs extends WebNavPage{

    private RadioMeModule radioMePage = new RadioMeModule();
    Response res = null;
    public JSONObject jObj = new JSONObject();

    @Given("^I am on Radio me module$")
    public void I_am_on_Radio_me_module() throws Throwable {
        openWebPage(System.getProperty("baseUrl") + "/radio/favourites");
        sleepInSeconds(3);
    }


    @Then("^Title of the \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void Title_of_the_should_be(String arg1, String arg2) throws Throwable {
        if(arg1.equals("first_tab")){
            assertIfTwoTextsEqual(getText(radioMePage.programmeUpdate),arg2);
        }else if(arg1.equals("second_tab")){
            assertIfTwoTextsEqual(getText(radioMePage.episodesClips),arg2);
        }
    }


    @Given("^I change page language to \"([^\"]*)\"$")
    public void I_change_page_language_to(String arg1) throws Throwable {
        if(arg1.equals("Cymraeg")){
            clickALink(radioMePage.cyLanguage);
        }else if(arg1.equals("Gaeilge")){
            clickALink(radioMePage.gaLanguage);
        }else if(arg1.equals("Gàidhlig")){
            clickALink(radioMePage.gdLanguage);
        }
    }

    @Given("^I click on the \"([^\"]*)\" tab$")
    public void I_click_on_the_tab(String arg1) throws Throwable {
        if(arg1.equals("Programme Updates")){
            clickALink(radioMePage.programmeUpdate);
        }else if(arg1.equals("Episodes & Clips")){
            clickALink(radioMePage.episodesClips);
        }
    }


    @Then("^description text \"([^\"]*)\" should be displayed at the top$")
    public void description_text_should_be_displayed_at_the_top(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1, getText(radioMePage.tabDescription));
    }


    @Given("^Page should have title \"([^\"]*)\"$")
    public void Page_should_have_title(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getText(radioMePage.pageTitle));
    }


    @Then("^Benefits page should have \"([^\"]*)\"$")
    public void Benefits_page_should_have(String arg1) throws Throwable {
        assertEquals(true,radioMePage.verifyBenefitsPageContents(arg1));

    }


    @Then("^Empty page should have first line \"([^\"]*)\"$")
    public void Empty_page_should_have_first_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getText(radioMePage.emptyPageFirstLine));
    }


    @Then("^Empty page should have second line \"([^\"]*)\"$")
    public void Empty_page_should_have_second_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getText(radioMePage.emptyPageSecondLine));
    }


    @Then("^Empty page should have desired image on it$")
    public void Empty_page_should_have_desired_image_on_it() throws Throwable {
        elementIsVisible(radioMePage.emptyPageImage);
    }


    @Then("^clicking on tile should take user to respective programmes page$")
    public void clicking_on_tile_should_take_user_to_respective_programmes_page() throws Throwable {

        assertIfTwoTextsEqual(getPropertyOfElement(radioMePage.clickableTileInMeModule,"href"),"http://www.bbc.co.uk/programmes/"+getPropertyOfElement(radioMePage.firstItemInList,"data-id"));

    }

    @When("^I get me service response from brand$")
    public void I_get_me_service_response_from_brand() throws Throwable {
        RestAssured.appendURL("/my/content/meta/radio/tlec/" + getPropertyOfElement(radioMePage.firstBrandInList,"data-id") + "/newItems?key=3irk89d66");
        RestAssured.performGetRequest();
        res = RestAssured.getResponse();
        jObj = new JSONObject(res.asString());

    }

    @Then("^view episode pane should be displayed as per available episode for brand$")
    public void view_episode_pane_should_be_displayed_as_per_available_episode_for_brand() throws Throwable {

        if(jObj.getInt("total")==0){
            assertTrue(elementIsVisible(radioMePage.moreItemsFromBrand));
            assertIfTwoTextsEqual(getText(radioMePage.moreItemsFromBrand),"No available episodes");
        }else if(jObj.getInt("total")==1){
            assertFalse(elementIsVisible(radioMePage.moreItemsFromBrand));
        }else if(jObj.getInt("total")>1 && jObj.getInt("total")<=25){
            assertTrue(elementIsVisible(radioMePage.moreItemsFromBrand));
           // String noOfAvailableEpisodes = jObj.getString("total");
            assertIfTwoTextsEqual(getText(radioMePage.moreItemsFromBrand),"View "+ jObj.getString("total") +" available episodes");
            assertIfTwoTextsEqual(getPropertyOfElement(radioMePage.moreLinkNavigation,"href"),jObj.getString("url")+"/episodes/player");
        }else if(jObj.getInt("total")>25){
            assertTrue(elementIsVisible(radioMePage.moreItemsFromBrand));
            assertIfTwoTextsEqual(getText(radioMePage.moreItemsFromBrand),"View all available episodes");
            assertIfTwoTextsEqual(getPropertyOfElement(radioMePage.moreLinkNavigation,"href"),jObj.getString("url")+"/episodes/player");
        }

    }

    @Then("^clicking on brand tile should take user to respective page$")
    public void clicking_on_brand_tile_should_take_user_to_respective_page() throws Throwable {
//        RestAssured.appendURL("/my/content/meta/radio/tlec/" + getPropertyOfElement(radioMePage.firstBrandInList,"data-id") + "/newItems?key=3irk89d66");
//        RestAssured.performGetRequest();
//        res = RestAssured.getResponse();
//        jObj = new JSONObject(res.asString());

        if(jObj.getInt("total")!=0){ //if total is not equal to 0
            assertIfTwoTextsEqual(getPropertyOfElement(radioMePage.clickableBrandInMeModule,"href"),jObj.getJSONArray("episodes").getJSONObject(0).getString("url"));
        }else{ //if episodes are not available for a brand (if total is equal to 0)
            assertIfTwoTextsEqual(getPropertyOfElement(radioMePage.clickableBrandInMeModule,"href"),jObj.getString("url"));
        }
    }






}
