package FavouritesMe_Module_E2ETest.HelperMethods;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static junit.framework.Assert.assertTrue;

/**
 * Created by patilk01 on 09/07/2015.
 */
public class PTRT extends WebNavPage{

    //To return encoded URL
    public static String getEncodedURL(String PTRT) {
        try {
            return URLEncoder.encode(PTRT, "UTF-8"); // http%3A%2F%2Fexample.com%2Ffoo%3Fkey%3Dval%7Cwith%5E%7Cbad%7Ccharacters
        } catch (UnsupportedEncodingException e) {
            e.getMessage();
            return "abc";
        }
    }

    public static boolean ptrtSetTo(String PTRT) {
        return currentURL().contains("ptrt=") && currentURL().endsWith(getEncodedURL(PTRT));
    }
}
