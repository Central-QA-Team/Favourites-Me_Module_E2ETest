package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.pageObject.*;

import cucumber.api.java.en.Given;

/**
 * Created by patilk01 on 19/06/2015.
 */
public class SignInStepdefs{
    private SignIn signInPage = new SignIn();

    @Given("^I signed in from benefits page as a normal user$")
    public void I_signed_in_from_benefits_page_as_a_normal_user() throws Throwable {
        signInPage.signInFromBenifitsPage().click();
        signInPage.sign_In("richard.mass123@gmail.com", "BBCpsptest5");
    }

    @Given("^I signed in from benefits page as a new user$")
    public void I_signed_in_from_benefits_page_as_a_new_user() throws Throwable {
        signInPage.signInFromBenifitsPage().click();
        signInPage.sign_In("NEWUSER@gmail.com", "NEWUSER");
    }

}
