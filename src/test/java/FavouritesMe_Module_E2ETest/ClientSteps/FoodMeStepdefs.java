package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Helper.HelperMethods;
import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.FoodFavourite;
import FavouritesMe_Module_E2ETest.pageObject.FoodMeModule;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by patilk01 on 24/06/2015.
 */
public class FoodMeStepdefs extends WebNavPage{

    private FoodMeModule foodMePage = new FoodMeModule();
     public String deletedRecipe = null;

    @Given("^I am on Food me module$")
    public void I_am_on_Food_me_module() throws Throwable {
        openWebPage(System.getProperty("baseUrl") + "/food/my/favourites");
        //openWebPage("http://www.test.bbc.co.uk/food/my/favourites");
        sleepInSeconds(3);
    }

    @Given("^Food page should have title \"([^\"]*)\"$")
    public void Food_page_should_have_title(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getText(foodMePage.pageTitle));
    }

    @Then("^Food empty page should have desired image on it$")
    public void Food_empty_page_should_have_desired_image_on_it() throws Throwable {
        elementIsVisible(foodMePage.emptyPageImage);
    }

    @Then("^Food empty page should have first line \"([^\"]*)\"$")
    public void Food_empty_page_should_have_first_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getText(foodMePage.emptyPageFirstLine));
    }

    @Then("^Food empty page should have second line \"([^\"]*)\"$")
    public void Food_empty_page_should_have_second_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getText(foodMePage.emptyPageSecondLine));
    }

    @Then("^Food empty page should have second line appended with favourite button image$")
    public void Food_empty_page_should_have_second_line_appended_with_favourite_button_image() throws Throwable {
        elementIsVisible(foodMePage.favouriteImageInSecondLink);
    }

    @Then("^Food empty page should have third line \"([^\"]*)\"$")
    public void Food_empty_page_should_have_third_line(String arg1) throws Throwable {
        assertIfTwoTextsEqual(arg1,getText(foodMePage.emptyPageThirdLine));
    }

    @Then("^Link Recipe index page should point to recipe page.$")
    public void Link_Recipe_index_page_should_point_to_recipe_page() throws Throwable {
        assertIfTwoTextsEqual("http://www.test.bbc.co.uk"+"/food/recipes/",getPropertyOfElement(foodMePage.recipeIndexLink, "href"));
    }

    @Then("^Food benefits page should have \"([^\"]*)\"$")
    public void Food_benefits_page_should_have(String arg1) throws Throwable {
        assertTrue(foodMePage.verifyBenefitsPageContents(arg1));

    }

    @Then("^clicking on tile should take user to respective recipe page$")
    public void clicking_on_tile_should_take_user_to_respective_recipe_page() throws Throwable {
        assertIfTwoTextsEqual(getPropertyOfElement(foodMePage.clickableTileInMeModule,"href"),"http://www.bbc.co.uk/food/recipes/"+getPropertyOfElement(foodMePage.firstItemInList,"data-id"));
    }

//    @Given("^user should have at max (\\d+) recipes per page$")
//    public void user_should_have_at_max_recipes_per_page(int recipesPerPage) throws Throwable {
//       assertTrue(foodMePage.getFavouriteListPerPage()<=recipesPerPage);
//    }


//    @When("^I delete item from action panel$")
//    public void I_delete_item_from_action_panel() throws Throwable {
//        deletedRecipe=getPropertyOfElement(foodMePage.firstItemInList, "data-id");
//        foodMePage.confirmDelete();
//        waitForShortSpan();
//    }
//
//
//    @Then("^item should be removed from me module$")
//    public void item_should_be_removed_from_me_module() throws Throwable {
//        assertFalse(deletedRecipe.equals(getPropertyOfElement(foodMePage.firstItemInList, "data-id")));
//    }


    @When("^I go to recipe page$")
    public void I_go_to_recipe_page() throws Throwable {
        openWebPage(System.getProperty("baseUrl") + "/food/recipes/" + deletedRecipe);
    }

//    @Then("^action panel will be displayed as (\\d+) vertical dots$")
//    public void action_panel_will_be_displayed_as_vertical_dots(int arg1) throws Throwable {
//        assertIfTwoTextsEqual("•\n•\n•",getText(foodMePage.actionPanel));
//    }

//    @Given("^action panel should contain \"([^\"]*)\"$")
//    public void action_panel_should_contain(String arg1) throws Throwable {
//        assertTrue(foodMePage.verifyActionPanelContents(arg1));
//    }
}
