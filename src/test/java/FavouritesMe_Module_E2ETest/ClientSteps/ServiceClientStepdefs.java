package FavouritesMe_Module_E2ETest.ClientSteps;


import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 15/05/15
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */
public class ServiceClientStepdefs {
    @Given("^The user is on BBC website$")
    public void The_user_is_on_BBC_website() throws Throwable {
        WebNavPage.openWebPage("http://www.bbc.co.uk/");

        sleepInSeconds(3);
    }

    protected void sleepInSeconds(int timeInSecs) {
        try {
            Thread.sleep(timeInSecs * 1000);
        } catch (InterruptedException e) {
        }

    }

    @When("^he clicks on News link$")
    public void he_clicks_on_News_link() throws Throwable {
     //WebNavPage.clickALinkWithCssLocator("div.orb-nav-links li.orb-nav-news.orb-d");
        WebNavPage.clickALink("//a[contains(text(),'News')]");
    }

    @Then("^I should be able to see Home link$")
    public void I_should_be_able_to_see_Home_link() throws Throwable {
          sleepInSeconds(3);
           WebNavPage.assertPageTitle("Home - BBC News");

    }
}
