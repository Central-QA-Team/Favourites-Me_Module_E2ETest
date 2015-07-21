package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import FavouritesMe_Module_E2ETest.pageObject.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

/**
 * Created by khotd01 on 06/07/2015.
 */
public class FoodFavouriteStepdefs extends WebNavPage{
    SignIn signIn= new SignIn();
    FoodFavourite foodFavourite = new FoodFavourite();
    FoodMeModule foodMe= new FoodMeModule();
    String recipe=null;
    public String ptrt=null;

    @Given("^I am on Food homepage$")
    public void I_am_on_Food_homepage() throws Throwable {
        String url=System.getProperty("baseUrl")+"/food";
        openWebPage(url);

    }

    
    @Given("^I find a recipe$")
    public void I_find_a_recipe() throws Throwable {
        foodFavourite.I_find_a_recipe();
    }


    @When("^I remove recipe from Favourite$")
    public void I_remove_recipe_from_Favourite() throws Throwable {
        foodFavourite.I_find_a_recipe();
        if(!getText(foodFavourite.favouriteButton).toLowerCase().contains("Added to Favourites".toLowerCase())) {
            clickALink(foodFavourite.favouriteButton);
            waitForShortSpan();
            clickALink(foodFavourite.favouriteButton);
        }
        clickALink(foodFavourite.favouriteButton);
    }


    @When("^I add recipe to Favourite")
    public void I_add_recipe_to_Favourite() throws Throwable {
        foodFavourite.I_find_a_recipe();
        if(getText(foodFavourite.favouriteButton).toLowerCase().contains("Added to Favourites".toLowerCase())) {
            clickALink(foodFavourite.favouriteButton);
            waitForShortSpan();
        }
        clickALink(foodFavourite.favouriteButton);
    }


    @Then("^the status of the button changes to Added to Favourites$")
    public void the_status_of_the_button_changes_to_Added_to_Favourites() throws Throwable {
        waitForShortSpan();
        assertContentExists(foodFavourite.favouriteButton, "\"" + foodFavourite.recipe + "\"" + " Added to Favourites");
    }


    @Then("^I can find  the recipe on food me module$")
    public void I_can_find_the_recipe_on_food_me_module() throws Throwable {
        clickALink(foodFavourite.yourFavourites);
        assertContentExists(foodMe.firstElementTitle,foodFavourite.recipe);

    }


    @When("^I hover the mouse pointer on favorite button$")
    public void user_hover_the_mouse_pointer_on_favorite_button() throws Throwable {
        mouseHover(foodFavourite.favouriteButton);
    }


    @Then("^button label should change from added state to remove state$")
    public void button_label_should_change_from_added_state_to_remove_state() throws Throwable {
        assertContentExists(foodFavourite.favouriteButtonStatus, "Remove");

    }


    @Given("^I have already added a item to favorite$")
    public void I_have_already_added_any_item_to_favorite() throws Throwable {
        clickALink(foodFavourite.yourFavourites);
        clickALink(By.xpath("//contains(text()," + foodFavourite.recipe + ")"));
    }


    @Then("^item should be removed from favorite$")
    public void item_should_be_removed_from_favorite() throws Throwable {
        assertContentExists(foodFavourite.favouriteButtonStatus, "");

    }


    @Then("^button should change to Add state$")
    public void button_should_change_to_Add_state() throws Throwable {
        waitForShortSpan();
        assertContentExists(foodFavourite.favouriteButton, "Add "+"\"" + foodFavourite.recipe + "\"" + " to Favourites");
    }


    @Then("^I click on register from idICTA$")
    public void I_click_on_register_from_idICTA() throws  Throwable {
        clickALink(signIn.registerCTA);
    }

}
