package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Helper.HelperMethods;
import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import FavouritesMe_Module_E2ETest.restassured.RestAssured;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonArray;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Date;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import org.eclipse.jetty.util.ajax.JSON;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by patilk01 on 18/06/2015.
 */
public class RadioMeStepdefs extends WebNavPage{

    Response metadata= null;
    int brandWithEpisodes = 0;
    public JSONObject jsonObj = new JSONObject();

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
            assertIfTwoTextsEqual(getText(radioMePage.programmeUpdate), arg2);
        }else if(arg1.equals("second_tab")){
            assertIfTwoTextsEqual(getText(radioMePage.episodesClips), arg2);
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
        assertIfTwoTextsEqual(arg1, getText(radioMePage.pageTitle));
    }


    @Then("^Benefits page should have \"([^\"]*)\"$")
    public void Benefits_page_should_have(String arg1) throws Throwable {
        assertEquals(true, radioMePage.verifyBenefitsPageContents(arg1));

    }


    @Then("^Empty page should have first line \"([^\"]*)\"$")
    public void Empty_page_should_have_first_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1, getText(radioMePage.emptyPageFirstLine));
    }


    @Then("^Empty page should have second line \"([^\"]*)\"$")
    public void Empty_page_should_have_second_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1, getText(radioMePage.emptyPageSecondLine));
    }


    @Then("^Empty page should have desired image on it$")
    public void Empty_page_should_have_desired_image_on_it() throws Throwable {
        elementIsVisible(radioMePage.emptyPageImage);
    }


    @Then("^clicking on tile should take user to respective programmes page$")
    public void clicking_on_tile_should_take_user_to_respective_programmes_page() throws Throwable {

        assertIfTwoTextsEqual(getPropertyOfElement(radioMePage.clickableTileInMeModule, "href"), "http://www.bbc.co.uk/programmes/" + getPropertyOfElement(radioMePage.firstItemInList, "data-id"));

    }


    @Then("^brands will be ordered as brand with latest available episode first$")
    public void brands_will_be_ordered_as_brand_with_latest_available_episode_first() throws Throwable {
        List<Date> dates = new ArrayList<Date>();
        List<String> pids = new ArrayList<String>();
        List<WebElement>  brandsWithEpisodeDatesOnAPage = getWebElements(radioMePage.brandsWithEpisodeDatesOnAPage);
        brandWithEpisodes = brandsWithEpisodeDatesOnAPage.size();
        for(int i=1;i<=brandWithEpisodes;i++ ){
            pids.add(getPropertyOfElement(By.xpath("//div/div[2]/div/ol/li[" + i + "]"), "data-id"));
        }

        Iterator<String> iterator = pids.iterator();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while(iterator.hasNext()){
            String stringDate = getLatestEpisodeOnDemandStartDate(iterator.next()).split("T")[0];
            dates.add(sdf.parse(stringDate));
        }

        Collections.reverse(dates);

        Assert.assertTrue("True if Dates are in chronological order", HelperMethods.ifDateListSorted(dates));
    }

    public String getLatestEpisodeOnDemandStartDate(String pid){
        String date=null;
        RestAssured.setRequestURL(RestAssured.getBaseURL()+"/my/content/meta/radio/tlec/" + pid + "/newItems?key=3irk89d66");
        RestAssured.performGetRequest();
        metadata = RestAssured.getResponse();
        try {
            jsonObj = new JSONObject(metadata.asString());
            date = jsonObj.getJSONArray("episodes").getJSONObject(0).getJSONObject("publication").getJSONObject("ondemand").getJSONObject("startDate").get("datetime").toString();

        }catch(JSONException je) {
            System.out.println("Wrong Json"+ je.getMessage());
            System.exit(0);
        }
        System.out.println(date);

        return date;

    }

    @Then("^brand with no available episode will be displayed at the last$")
    public void brand_with_no_available_episode_will_be_displayed_at_the_last() throws Throwable {
        List<WebElement>  allRows = getWebElements(radioMePage.allRowsOnAPage);

        List<Date> dates = new ArrayList<Date>();
        if(allRows.size()>brandWithEpisodes)
        for(int i=brandWithEpisodes+1; i<allRows.size();i++){
            Assert.assertTrue(elementExists(By.xpath("//li[" + i + " ]/span/span/a/span[2]/span[1]/span/span")));
            Assert.assertFalse("True if Brands with no episodes are at the end of the list", elementExists(By.xpath("//li[" + i + "]/span/span/a/span[2]/span[2]/span[1]/span/span[2]")));
        }

    }


}
