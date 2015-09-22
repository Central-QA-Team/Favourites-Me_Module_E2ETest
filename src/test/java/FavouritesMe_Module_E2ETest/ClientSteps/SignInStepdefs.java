package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.*;
import FavouritesMe_Module_E2ETest.SharedDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import org.apache.http.client.utils.URLEncodedUtils;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by patilk01 on 19/06/2015.
 */
public class SignInStepdefs extends WebNavPage{
    private SignIn signInPage = new SignIn();

    @Given("^I signed in from benefits page as a normal user$")
    public void I_signed_in_from_benefits_page_as_a_normal_user() throws Throwable {
        clickALink(signInPage.signInButtonInCTA);
        signInPage.sign_In(System.getProperty("userWithFav"), System.getProperty("passWithFav"));

    }

    @Given("^I signed in from benefits page as a new user$")
    public void I_signed_in_from_benefits_page_as_a_new_user() throws Throwable {
        clickALink(signInPage.signInButtonInCTA);
        signInPage.sign_In(System.getProperty("userWithNoFav"), System.getProperty("passWithNoFav"));
    }

    @Then("^Benefits page should have ID CTA with text \"([^\"]*)\"$")
    public void Benefits_page_should_have_ID_CTA_with_text(String cta_text) throws Throwable {
        elementIsVisible(signInPage.idCTA);
        assertEquals(true, signInPage.signInCTAContaints(cta_text));
    }

    @When("^I click on Sign In button on benefits page$")
    public void I_click_on_Sign_In_button_on_benefits_page() throws Throwable {
        clickALink(signInPage.signInButtonInCTA);
    }

    @When("^I click on Register button on benefits page$")
    public void I_click_on_Register_button_on_benefits_page() throws Throwable {
        clickALink(signInPage.registerButtonInCTA);
    }

    @When("^I sign in from idCTA$")
    public void I_sign_in_from_idCTA() throws Throwable {
        clickALink(signInPage.signInCTA);
        signInPage.sign_In(System.getProperty("userWithFav"), System.getProperty("passWithFav"));
    }

    @Given("^I am a signed in user$")
    public void I_am_a_signed_in_user() throws Throwable {
        openWebPage(System.getProperty("baseUrl"));
        clickALink(signInPage.signInBarlesqueMenu);
        signInPage.sign_In(System.getProperty("userWithFav"), System.getProperty("passWithFav"));
        waitForShortSpan();
    }

    @Given("^I am a signed in user username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void I_am_a_signed_in_user_username_and_password(String userName, String password) throws Throwable {
        openWebPage(System.getProperty("baseUrl"));
        clickALink(signInPage.signInBarlesqueMenu);
        signInPage.sign_In(userName,password);
        waitForShortSpan();
    }


}
