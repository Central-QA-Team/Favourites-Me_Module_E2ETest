package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import static FavouritesMe_Module_E2ETest.SharedDriver.getDriver;
import FavouritesMe_Module_E2ETest.pageObject.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * Created by patilk01 on 19/06/2015.
 */
public class signInStepdefs {


    @Given("^I signed in from benefits page as a normal user$")
    public void I_signed_in_from_benefits_page_as_a_normal_user() throws Throwable {
        FavouritesMe_Module_E2ETest.pageObject.signIn.signInFromBenifitsPage().click();
        FavouritesMe_Module_E2ETest.pageObject.signIn.signIn("Kalyani2013", "Kalyani2013");
    }

    @Given("^I signed in from benefits page as a new user$")
    public void I_signed_in_from_benefits_page_as_a_new_user() throws Throwable {
        FavouritesMe_Module_E2ETest.pageObject.signIn.signInFromBenifitsPage().click();
        FavouritesMe_Module_E2ETest.pageObject.signIn.signIn("NEWUSER@gmail.com", "NEWUSER");
    }

}
