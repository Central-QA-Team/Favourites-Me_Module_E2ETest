package FavouritesMe_Module_E2ETest.pageObject;


import org.openqa.selenium.By;

/**
 * Created by patilk01 on 24/06/2015.
 */
public class FoodMeModule extends MeModuleCommonControls{

    private FoodFavourite foodFavourite = new FoodFavourite();

    public By pageTitle = By.xpath(".//*[@id='column-1']/h1");
    public By emptyPageFirstLine = By.xpath(".//*[@class='my-text-1']");
    public By emptyPageSecondLine = By.xpath(".//*[@class='my-text-2']");
    public By favouriteImageInSecondLink = By.xpath(".//*[@class='my-text-2']/img");
    public By emptyPageThirdLine = By.xpath(".//*[@class='my-text-3']");
    public By emptyPageImage = By.xpath(".//*[@class='my-icon-signed-in-no-favourites']");
    public By recipeIndexLink = By.xpath(".//*[@class='my-text-3']/a");
    public By firstElementTitle = By.xpath("//li[1]/span/span/a/span/span[1]");

}
