package FavouritesMe_Module_E2ETest.Helper;

import FavouritesMe_Module_E2ETest.Selenium.WebNavPage;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
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


    // returns minutes
    public static String getMinutes(String duration){
        int mins=0;
        String temp = duration.substring(2);
        if (temp.charAt(temp.length()-1)=='M'){
            if (temp.contains("H")) {
                mins += Integer.parseInt(temp.substring(0, temp.indexOf('H'))) * 60;
                mins += Integer.parseInt(temp.substring(temp.indexOf('H') + 1, temp.indexOf('M')));
            } else {
                mins += Integer.parseInt(temp.substring(0, temp.indexOf('M')));
            }
        } else {
            mins += Integer.parseInt(temp.substring(0, temp.indexOf('H'))) * 60;
        }
        return  Integer.toString(mins);
    }


    //returns date in "dd M yyyy" format from "yyyy-mm-dd"
    public static String getDate_d_M_y(String date){
        String month= null;
        String temp [] = date.split("-");
        int i = Integer.parseInt(temp[1]);
        switch (i){
            case 1:
                month = "Jan";
                break;
            case 2:
                month = "Feb";
                break;
            case 3:
                month = "Mar";
                break;
            case 4:
                month = "Apr";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "Jun";
                break;
            case 7:
                month = "Jul";
                break;
            case 8:
                month = "Aug";
                break;
            case 9:
                month = "Sep";
                break;
            case 10:
                month = "Oct";
                break;
            case 11:
                month = "Nov";
                break;
            case 12:
                month = "Dec";
                break;
        }

        return temp[2]+" "+month+" "+temp[0]+".";
    }


    //to return true or false depending on given String List is sorted or not
    public static boolean ifStringListSorted(List<String> follows){
        boolean isSorted = true;
        for(int i = 0; i < follows.size()-1 ; i++) {
            // current String is > than the next one (if there are equal list is still sorted)
            if(follows.get(i).compareToIgnoreCase(follows.get(i + 1)) > 0) {
                isSorted = false;
                break;
            }
        }
        return isSorted;

    }

    //to return true or false depending on given Date List is sorted or not
    public static boolean ifDateListSorted(List<Date> dates){
        boolean isSorted = true;
        for(int i = 0; i < dates.size()-1 ; i++) {
            // current String is > than the next one (if there are equal list is still sorted)
            if (dates.get(i).compareTo(dates.get(i + 1)) > 0) {
                isSorted = false;
                break;
            }
        }
        return isSorted;

    }


}
