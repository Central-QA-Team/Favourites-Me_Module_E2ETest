package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.FoodMeModule;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by patilk01 on 24/06/2015.
 */
public class FoodMeStepdefs extends WebNavPage{

    private FoodMeModule foodMePage = new FoodMeModule();

    @Given("^I am on Food me module$")
    public void I_am_on_Food_me_module() throws Throwable {
        openWebPage("http://www.test.bbc.co.uk" + "/food/my/favourites");
        sleepInSeconds(3);
    }

    @Given("^Food page should have title \"([^\"]*)\"$")
    public void Food_page_should_have_title(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getTextUsingBy(foodMePage.pageTitle));
    }


    @Then("^Food empty page should have desired image on it$")
    public void Food_empty_page_should_have_desired_image_on_it() throws Throwable {
        elementIsVisibleUsingBy(foodMePage.emptyPageImage);
    }

    @Then("^Food empty page should have first line \"([^\"]*)\"$")
    public void Food_empty_page_should_have_first_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getTextUsingBy(foodMePage.emptyPageFirstLine));
    }

    @Then("^Food empty page should have second line \"([^\"]*)\"$")
    public void Food_empty_page_should_have_second_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getTextUsingBy(foodMePage.emptyPageSecondLine));
    }

    @Then("^Food empty page should have second line appended with favourite button image$")
    public void Food_empty_page_should_have_second_line_appended_with_favourite_button_image() throws Throwable {
        elementIsVisibleUsingBy(foodMePage.favouriteImageInSecondLink);
    }

    @Then("^Food empty page should have third line \"([^\"]*)\"$")
    public void Food_empty_page_should_have_third_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getTextUsingBy(foodMePage.emptyPageThirdLine));
    }

    @Then("^Link Recipe index page should point to recipe page.$")
    public void Link_Recipe_index_page_should_point_to_recipe_page() throws Throwable {
        assertIfTwoTextsEqual("http://www.test.bbc.co.uk"+"/food/recipes/",getPropertyOfElementUsingBy(foodMePage.recipeIndexLink, "href"));
    }

    @Then("^Food benefits page should have \"([^\"]*)\"$")
    public void Food_benefits_page_should_have(String arg1) throws Throwable {
        assertEquals(true, foodMePage.verifyBenefitsPageContents(arg1));

    }

}
