package FavouritesMe_Module_E2ETest.pageObject;
import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;
import static FavouritesMe_Module_E2ETest.SharedDriver.getDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by patilk01 on 19/06/2015.
 */
public class SignIn {

    private static WebElement element = null;

    By usernameInputBox = By.cssSelector("#bbcid_unique");
    By passwordInputBox = By.cssSelector("#bbcid_password");
    By signInButton = By.cssSelector("#bbcid_submit_button");
    By cancelButton = By.cssSelector(".bbcid-button.cancel");
    By signInFromBenifitsPage = By.cssSelector(".id4-cta-signin.id4-cta-button");
    //public static String signIn = ".id4-cta-signin.id4-cta-button";
    public WebElement usernameInputBox(){

        element = getDriver().findElement(usernameInputBox);

        return element;

    }

    public WebElement passwordInputBox(){

        element = getDriver().findElement(passwordInputBox);

        return element;

    }

    public WebElement signInButton(){

        element = getDriver().findElement(signInButton);

        return element;

    }

    public WebElement cancelButton(){

        element = getDriver().findElement(cancelButton);

        return element;

    }


    public WebElement signInFromBenifitsPage(){

        element = getDriver().findElement(signInFromBenifitsPage);
        return element;

    }

    public void sign_In(String userID, String password) {

        usernameInputBox().clear();
        usernameInputBox().sendKeys(userID);
        passwordInputBox().clear();
        passwordInputBox().sendKeys(password);
        signInButton().click();
    }


}
