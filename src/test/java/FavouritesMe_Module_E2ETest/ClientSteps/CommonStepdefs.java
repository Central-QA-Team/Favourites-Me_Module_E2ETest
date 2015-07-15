package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Helper.HelperMethods;
import FavouritesMe_Module_E2ETest.pageObject.MeModuleCommonControls;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import java.lang.reflect.Member;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by khotd01 on 09/07/2015.
 */
public class CommonStepdefs extends WebNavPage{

    private HelperMethods helperMethods = new HelperMethods();
    private MeModuleCommonControls mePage = new MeModuleCommonControls();
    public String deletedRecipe = null;


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


    @When("^I delete item from action panel$")
    public void I_delete_item_from_action_panel() throws Throwable {
        deletedRecipe=getPropertyOfElement(mePage.firstItemInList, "data-id");
        mePage.confirmDelete();
        waitForShortSpan();
    }

    @Then("^item should be removed from me module$")
    public void item_should_be_removed_from_me_module() throws Throwable {
        assertFalse(deletedRecipe.equals(getPropertyOfElement(mePage.firstItemInList, "data-id")));
    }

    @Then("^action panel will be displayed as (\\d+) vertical dots$")
    public void action_panel_will_be_displayed_as_vertical_dots(int arg1) throws Throwable {
        assertIfTwoTextsEqual("•\n•\n•",getText(mePage.actionPanel));
    }

    @Given("^action panel should contain \"([^\"]*)\"$")
    public void action_panel_should_contain(String arg1) throws Throwable {
        assertTrue(mePage.verifyActionPanelContents(arg1));
    }

    @Given("^user should have at max (\\d+) per page$")
    public void user_should_have_at_max_programmes_per_page(int programmesPerPage) throws Throwable {
        Assert.assertTrue(mePage.getFavouriteListPerPage() <= programmesPerPage);
    }

}
