package FavouritesMe_Module_E2ETest.Helper;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

import static junit.framework.Assert.assertTrue;

/**
 * Created by patilk01 on 09/07/2015.
 */
public class HelperMethods extends WebNavPage {

    //to verify ptrt value
    public static boolean ptrtSetTo(String PTRT) {
        try {
            return (URLDecoder.decode(currentURL(), "UTF-8").contains(("ptrt=" + PTRT).replace("www.test.bbc.co.uk","test.bbc.co.uk")) || URLDecoder.decode(currentURL(), "UTF-8").contains("[ptrt]=" + PTRT));
        } catch (UnsupportedEncodingException uee) {
            uee.getMessage();
            return false;
        }
    }


    //to generate random number between a range
    public static int randomNumber(int max){
            Random random = new Random();
            int randomNumber = random.nextInt(max)+1;
                return randomNumber;
    }

}
