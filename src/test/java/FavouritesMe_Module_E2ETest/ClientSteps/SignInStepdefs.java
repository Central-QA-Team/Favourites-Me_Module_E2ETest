package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by patilk01 on 19/06/2015.
 */
public class SignInStepdefs extends WebNavPage{
    private SignIn signInPage = new SignIn();

    @Given("^I signed in from benefits page as a normal user$")
    public void I_signed_in_from_benefits_page_as_a_normal_user() throws Throwable {
        clickALinkUsingBy(signInPage.signInFromBenifitsPage);
        signInPage.sign_In("richard.mass123@gmail.com", "BBCpsptest5");

    }

    @Given("^I signed in from benefits page as a new user$")
    public void I_signed_in_from_benefits_page_as_a_new_user() throws Throwable {
        clickALinkUsingBy(signInPage.signInFromBenifitsPage);
        signInPage.sign_In("NEWUSER@gmail.com", "NEWUSER");
    }

    @Then("^Benefits page should have ID CTA with text \"([^\"]*)\"$")
    public void Benefits_page_should_have_ID_CTA_with_text(String arg1) throws Throwable {
        elementIsVisibleUsingBy(signInPage.idCTA);
        assertEquals(true,signInPage.signInCTAContaints(arg1));
    }



}
