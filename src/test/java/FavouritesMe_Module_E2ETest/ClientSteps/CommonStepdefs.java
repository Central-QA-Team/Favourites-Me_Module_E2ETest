package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Helper.HelperMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;

import static junit.framework.Assert.assertTrue;

/**
 * Created by khotd01 on 09/07/2015.
 */
public class CommonStepdefs extends WebNavPage{
    private HelperMethods helperMethods = new HelperMethods();

    @Then("^I should be taken to \"([^\"]*)\" page$")
    public void I_should_be_taken_to_page(String pageTitle) throws Throwable {
        assertIfTwoTextsEqual(getTitle(),pageTitle);

    }

    @Given("^I navigate to BBC ([^\"]*) home page$")
    public void I_navigate_to_page(String endPoint) throws Throwable {
        String url=System.getProperty("baseUrl")+"/"+endPoint;
        openWebPage(url);

    }

    @Given("^I resize browser window to width \"([^\"]*)\" and height \"([^\"]*)\"$")
    public void I_resize_browser_window_to_width_and_height(String width, String height) throws Throwable {
        resize(Integer.parseInt(width), Integer.parseInt(height));
    }

    @Then("^PTRT should be set to \"([^\"]*)\"$")
    public void PTRT_should_be_set_to(String ptrt) throws Throwable {
        assertTrue(helperMethods.ptrtSetTo(System.getProperty("baseUrl")+ptrt));
    }


}
