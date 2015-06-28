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
public class SignIn extends WebNavPage{

    public By usernameInputBox = By.cssSelector("#bbcid_unique");
    public By passwordInputBox = By.cssSelector("#bbcid_password");
    public By signInButton = By.cssSelector("#bbcid_submit_button");
    public By cancelButton = By.cssSelector(".bbcid-button.cancel");
    public By signInFromBenifitsPage = By.cssSelector(".id4-cta-signin.id4-cta-button");
    public By idCTA = By.xpath(".//*[@id='id4-cta-1']");
    public By signInButtonInCTA = By.xpath(".//*[@id='id4-cta-1']/span/a[@class='id4-cta-signin id4-cta-button']");
    public By registerButtonInCTA = By.xpath(".//*[@id='id4-cta-1']/span/a[@class='id4-cta-register']");


    public void sign_In(String userID, String password) {

        clearAnyFieldUsingBy(usernameInputBox);
        enterAnyTextInAFieldUsingBy(usernameInputBox, userID);
        clearAnyFieldUsingBy(passwordInputBox);
        enterAnyTextInAFieldUsingBy(passwordInputBox, password);
        clickALinkUsingBy(signInButton);

    }

    public boolean signInCTAContaints(String arg1) {
        return assertIfTwoTextsEqual(arg1.replaceAll("\\n", ""),getTextUsingBy(idCTA).replaceAll("\\n", "")) && elementExistsUsingBy(signInButtonInCTA) && elementExistsUsingBy(registerButtonInCTA);
       }

}
