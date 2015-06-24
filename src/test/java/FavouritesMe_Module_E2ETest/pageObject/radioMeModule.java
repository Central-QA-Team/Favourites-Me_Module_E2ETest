package FavouritesMe_Module_E2ETest.pageObject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

/**
 * Created by patilk01 on 18/06/2015.
 */
public class radioMeModule {


    private static WebElement element = null;

        public static WebElement programmeUpdate(WebDriver driver){

            element = driver.findElement(By.className("my-tab my-active"));

            return element;

        }

        public static WebElement episodesClips(WebDriver driver){

            element = driver.findElement(By.id("my-tab"));

            return element;

        }




}



