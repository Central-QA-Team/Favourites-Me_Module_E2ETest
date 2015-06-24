package FavouritesMe_Module_E2ETest.ClientSteps;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;

import static FavouritesMe_Module_E2ETest.SharedDriver.getDriver;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.fail;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

/**
 * Created by patilk01 on 18/06/2015.
 */
public class radioMeStepdefs {
    @Given("^I am on Radio me module$")
    public void I_am_on_Radio_me_module() throws Throwable {
        WebNavPage.openWebPage("http://www.test.bbc.co.uk/radio/favourites");
        WebNavPage.sleepInSeconds(3);
    }



    @Then("^Title of the \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void Title_of_the_should_be(String arg1, String arg2) throws Throwable {
        int i=1;
        if(arg1.equals("first_tab")){
            i=1;
        }else if(arg1.equals("second_tab")){
            i=2;
        }
        assertTrue(WebNavPage.getText("xpath",".//*[@id='blq-content']/div/div[2]/div/div[2]/ul/li["+i+"]/a").equals(arg2));
    }


    @Given("^I change page language to \"([^\"]*)\"$")
    public void I_change_page_language_to(String arg1) throws Throwable {
        int i = 0;
        if(arg1.equals("Cymraeg")){
            i=1;
        }else if(arg1.equals("Gaeilge")){
            i=2;
        }else if(arg1.equals("Gàidhlig")){
            i=3;
        }
        WebNavPage.clickALink("xpath",".//*[@id='network-language-select']/li[" + i +"]/a");
    }

    @Given("^I click on the \"([^\"]*)\" tab$")
    public void I_click_on_the_tab(String arg1) throws Throwable {
        int i=1;
        if(arg1.equals("Programme Updates")){
            i=1;
        }else if(arg1.equals("Episodes & Clips")){
            i=2;
        }
        WebNavPage.clickALink("xpath",".//*[@id='blq-content']/div/div[2]/div/div[2]/ul/li["+i+"]/a");

    }

    @Then("^description text \"([^\"]*)\" should be displayed at the top$")
    public void description_text_should_be_displayed_at_the_top(String arg1) throws Throwable {
        assertEquals(arg1,WebNavPage.getText("xpath",".//*[@id='my-tabs-hint']"));
    }


    @Then("^Benefits page should have \"([^\"]*)\"$")
    public void Benefits_page_should_have(String arg1) throws Throwable {
        String[] array = arg1.split(",");
        assertEquals(array[0],WebNavPage.getText("xpath",".//*[@class='my-benefits-list']/li[1]"));
        assertEquals(array[1],WebNavPage.getText("xpath", ".//*[@class='my-benefits-list']/li[2]"));
        assertEquals(array[2],WebNavPage.getText("xpath", ".//*[@class='my-benefits-list']/li[3]"));
        WebNavPage.elementWithXPathIsVisible(".//*[@class='my-icon-benefits']");

    }

    @Then("^Empty page should have first line \"([^\"]*)\"$")
    public void Empty_page_should_have_first_line(String arg1) throws Throwable {

        assertEquals(arg1,WebNavPage.getText("xpath",".//*[@class='my-text-1']"));


    }
    @Then("^Empty page should have second line \"([^\"]*)\"$")
    public void Empty_page_should_have_second_line(String arg1) throws Throwable {

        assertEquals(arg1,WebNavPage.getText("xpath",".//*[@class='my-text-2']"));

    }

    @Then("^Empty page should have desired image on it$")
    public void Empty_page_should_have_desired_image_on_it() throws Throwable {
        WebNavPage.elementWithXPathIsVisible(".//*[@class='my-icon-signed-in-no-favourites']");
    }


    @Then("^Benefits page should have ID CTA$")
    public void Benefits_page_should_have_ID_CTA() throws Throwable {

    }

    @Given("^Page should have title \"([^\"]*)\"$")
    public void Page_should_have_title(String arg1) throws Throwable {
        assertEquals(arg1,WebNavPage.getText("xpath",".//*[@class='hdr-inner radio-container']"));

    }

}