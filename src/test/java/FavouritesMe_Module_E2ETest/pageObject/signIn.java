package FavouritesMe_Module_E2ETest.pageObject;
import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by patilk01 on 19/06/2015.
 */
public class signIn {

    private static WebElement element = null;

    public static WebElement usernameInputBox(WebDriver driver){

        element = driver.findElement(By.cssSelector("#bbcid_unique"));

        return element;

    }

    public static WebElement passwordInputBox(WebDriver driver){

        element = driver.findElement(By.cssSelector("#bbcid_password"));

        return element;

    }

    public static WebElement signInButton(WebDriver driver){

        element = driver.findElement(By.cssSelector("#bbcid_submit_button"));

        return element;

    }

    public static WebElement cancelButton(WebDriver driver){

        element = driver.findElement(By.cssSelector(".bbcid-button.cancel"));

        return element;

    }


    public static WebElement signInFromBenifitsPage(WebDriver driver){

        element = driver.findElement(By.cssSelector(".id4-cta-signin.id4-cta-button"));

        return element;

    }


}
