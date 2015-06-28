package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.*;
import static FavouritesMe_Module_E2ETest.SharedDriver.getDriver;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.fail;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by patilk01 on 18/06/2015.
 */
public class RadioMeStepdefs extends WebNavPage{

    private RadioMeModule radioMePage = new RadioMeModule();

    @Given("^I am on Radio me module$")
    public void I_am_on_Radio_me_module() throws Throwable {
        openWebPage("http://www.test.bbc.co.uk" + "/radio/favourites");
        sleepInSeconds(3);
    }



    @Then("^Title of the \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void Title_of_the_should_be(String arg1, String arg2) throws Throwable {
        if(arg1.equals("first_tab")){
            assertIfTwoTextsEqual(getTextUsingBy(radioMePage.programmeUpdate),arg2);
        }else if(arg1.equals("second_tab")){
            assertIfTwoTextsEqual(getTextUsingBy(radioMePage.episodesClips),arg2);
        }
    }


    @Given("^I change page language to \"([^\"]*)\"$")
    public void I_change_page_language_to(String arg1) throws Throwable {
        if(arg1.equals("Cymraeg")){
            clickALinkUsingBy(radioMePage.cyLanguage);
        }else if(arg1.equals("Gaeilge")){
            clickALinkUsingBy(radioMePage.gaLanguage);
        }else if(arg1.equals("Gàidhlig")){
            clickALinkUsingBy(radioMePage.gdLanguage);
        }
    }


    @Given("^I click on the \"([^\"]*)\" tab$")
    public void I_click_on_the_tab(String arg1) throws Throwable {
        if(arg1.equals("Programme Updates")){
            clickALinkUsingBy(radioMePage.programmeUpdate);
        }else if(arg1.equals("Episodes & Clips")){
            clickALinkUsingBy(radioMePage.episodesClips);
        }
    }


    @Then("^description text \"([^\"]*)\" should be displayed at the top$")
    public void description_text_should_be_displayed_at_the_top(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1, getTextUsingBy(radioMePage.tabDescription));
    }


    @Given("^Page should have title \"([^\"]*)\"$")
    public void Page_should_have_title(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getTextUsingBy(radioMePage.pageTitle));
    }


    @Then("^Benefits page should have \"([^\"]*)\"$")
    public void Benefits_page_should_have(String arg1) throws Throwable {
        assertEquals(true,radioMePage.verifyBenefitsPageContents(arg1));

    }


    @Then("^Empty page should have first line \"([^\"]*)\"$")
    public void Empty_page_should_have_first_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getTextUsingBy(radioMePage.emptyPageFirstLine));
    }


    @Then("^Empty page should have second line \"([^\"]*)\"$")
    public void Empty_page_should_have_second_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getTextUsingBy(radioMePage.emptyPageSecondLine));
    }


    @Then("^Empty page should have desired image on it$")
    public void Empty_page_should_have_desired_image_on_it() throws Throwable {
        elementIsVisibleUsingBy(radioMePage.emptyPageImage);
    }



}
