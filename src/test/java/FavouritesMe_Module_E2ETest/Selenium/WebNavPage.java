package FavouritesMe_Module_E2ETest.Selenium;


import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.seleniumemulation.JavascriptLibrary;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static FavouritesMe_Module_E2ETest.SharedDriver.getDriver;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
/**
 * Created by IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 29/03/12
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
public class WebNavPage {



    public static void openWebPage(String url) throws Exception {
        //setUp();
        //System.out.println(String.format("opening url %s", url));
        getDriver().get(url);

        //handleDialogPopUp();
        getDriver().manage().window().maximize();


    }

    public static void refreshPage(){

        getDriver().navigate().refresh();

    }

    public static void pressEnterKey(String fieldLocator){

        WebElement element =  getDriver().findElement(By.xpath(fieldLocator));
        element.sendKeys(Keys.RETURN);

    }
    public static void pressKeybordEnterKey(String fieldLocator){

        WebElement element =  getDriver().findElement(By.xpath(fieldLocator));
        element.sendKeys(Keys.ENTER);

    }

    public static void pressTABKey(String fieldLocator){

        WebElement element =  getDriver().findElement(By.xpath(fieldLocator));
        element.sendKeys(Keys.TAB);

    }
    public static void slideToLocation (String slider, int destinationX){
        /** Slide to a specified location on slider **/
        slide ( slider, destinationX, 0);
    }

    public static void slideByAmount (String slider, int amount){
        /** Slide by a specified number of units **/
        slide (slider, 0,amount);
    }

       /* public static void clearAutoText(String xpath){

            getDriver().findElement(By.xpath(xpath)).clear();

        }*/


    public static void slide (String slider, int destinationX, int moveByUnits ){
        /**
         * User: jward3
         * Date: 07/02/13
         * Time: 13:22
         * Slide method for selecting a position on a jquery ui slider
         * e.g. Selecting "Distance"
         **/
        getDriver().manage().window().maximize();

        //boolean exists =  getDriver().findElement(By.xpath(slider)).isEnabled();

        Point MyPoint= getDriver().findElement(By.xpath(slider)).getLocation();

        WebElement someElement = getDriver().findElement(By.xpath(slider));

        System.out.println(MyPoint.x+"--------"+MyPoint.y);

        Actions builder = new Actions(getDriver());

        int slideOffset = 0;

        if (destinationX > 0)  // will move to a specified location relative to current x coordinate
            slideOffset = MyPoint.x - destinationX;
        else if (moveByUnits > 0 || moveByUnits < 0)  // will move by specified number of pixels
            slideOffset = moveByUnits ;

        System.out.println("Will move from " + MyPoint.x + " by " + slideOffset);

        Action dragAndDrop =  builder.clickAndHold(someElement).moveByOffset(slideOffset,MyPoint.y).release().build();

        dragAndDrop.perform();

        System.out.println("finished drag");

    }

    //To Click a Links
    public static void clickALink(String locator){
        getDriver().findElement(By.xpath(locator)).click();
    }
    public static void clickParentLink(String locator){
        WebElement childElement=  getDriver().findElement(By.xpath(locator));
        WebElement ParentElement=  childElement.findElement(By.xpath(".."));
        ParentElement.click();
    }

    public static void clickALinkWithCssLocator(String cssLocator){

        getDriver().findElement(By.cssSelector(cssLocator)).click();
    }

    public static void navigateThruHREF(String xpath){

        try{
            getDriver().get(getDriver().findElement(By.xpath(xpath)).getAttribute("href"));
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        //
    }

    //To Enter Text in a field//
    public static void enterAnyTextInAField(String fieldLocator, String Text){

        WebElement element =  getDriver().findElement(By.xpath(fieldLocator));
        element.sendKeys(Text);
    }

    public static void enterAnyTextInAFieldWithCssLocator(String cssLocator, String text){

        WebElement element = getDriver().findElement(By.cssSelector(cssLocator));
        element.sendKeys(text);
    }

    public static void enterAnyNumberInAField(String fieldLocator, int anynumber){

        WebElement element =  getDriver().findElement(By.xpath(fieldLocator));
        String Text =  Integer.toString(anynumber);
        element.sendKeys(Text);
    }

    public static void clearAnyField(String fieldLocator){

        //Function to Clear any field;
        WebElement element =  getDriver().findElement(By.xpath(fieldLocator));
        element.clear();
    }

    public static String returnFutureDate(int noOfDaysFromToday){

        String todaysDateIs;
        String strDay = "";
        String strMonth = "";

        Calendar now = Calendar.getInstance();
        int YEAR = now.get(Calendar.YEAR);
        int MONTH = now.get(Calendar.MONTH);
        MONTH = MONTH + 1;
        int DAY = now.get(Calendar.DAY_OF_MONTH);
        DAY = DAY + noOfDaysFromToday;
        if (DAY<10){
            strDay = "0"+DAY;
        }else{
            strDay = Integer.toString(DAY);
        }
        if (MONTH<10){
            strMonth = "0"+MONTH;
        }else{
            strMonth = Integer.toString(MONTH);
        }
        todaysDateIs = strDay+"/"+strMonth+"/"+YEAR;
        System.out.print("the date expected is :"+ todaysDateIs);
        return todaysDateIs;
    }

    //Selects an Item from a Drop Down list.
    public static void selectAnOptionFromAList(String ListOption, String listLocator){

        selectingAnOptionFromList(ListOption, listLocator);
    }
    public static void iSubmitFormWithId(String formId) {
        getDriver().findElement(By.id(formId)).submit();
    }

    public static void checkACheckBox(String checkBoxLocator){

        WebElement element = getDriver().findElement(By.xpath(checkBoxLocator));

        try{
            element.click();
        } catch(Exception e){
            e.printStackTrace();
        }
    }



    public static void checkACheckBoxWithCssLocator(String checkBoxCssLocator){

        WebElement element = getDriver().findElement(By.cssSelector(checkBoxCssLocator));

        try{
            element.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getText(String xpath) {
        return getDriver().findElement(By.xpath(xpath)).getText();
    }

    public static String getxPathofVisibleText(String text) {
        String xPathLink ="(//span[contains(text(),'" + text + "')])";


        Integer numberofresult = getDriver().findElements(By.xpath(xPathLink)).size();

        if(numberofresult == 1)
            return xPathLink;
        for(int j = numberofresult; j >0; j--)
        {	if(WebNavPage.getText("(//span[contains(text(),'" + text + "')])[" + j + "]").length()>0)
            return "(//span[contains(text(),'" + text + "')])[" + j + "]";
        }

        return xPathLink;
    }



    public static String getAttributesOfElement(String xpath, String attribName){

        return getDriver().findElement(By.xpath(xpath)).getCssValue(attribName);

    }

    public static String getPropertyOfElement(String xpath, String attribName){

        return getDriver().findElement(By.xpath(xpath)).getAttribute(attribName);

    }

    public static String getAttribute(String xpath) {
        return getDriver().findElement(By.xpath(xpath)).getAttribute("value");
    }

    public static String getTitle(){
        return getDriver().getTitle();

    }

    public static String getHoverText(String xpath){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        String toolTip = element.getAttribute("title");
        //System.out.println("The Tool tip is :"+toolTip);
        return  toolTip;
    }



    //Element Verification Classes

    public static boolean elementWithXPathShouldBePresent(String xPath) {
        boolean name = true;
        try{
            assertTrue(String.format("Element with %s should be present", xPath), getDriver().findElement(By.xpath(xPath)) != null);
        } catch (Exception e){
            name = false;
            e.printStackTrace();
        }
        return name;
    }


    // not for verification
    public static boolean elementWithXPathExists(String xPath) {
        boolean exists = false;
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try
        {
            if (getDriver().findElement(By.xpath(xPath)) != null)
                exists = true;
            System.out.println("The Element exists and its Value is :"+getText(xPath));
        }
        catch(Exception e)
        {

        }
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return exists;
    }


    public static boolean assertPageTitle(String expPageTitle){
        boolean key = true;
        try {
            assertEquals(expPageTitle, getDriver().getTitle());
        }catch(Exception e){
            e.printStackTrace();
            key = false;
        }

        return key;
    }
    public static boolean elementWithXPathIsVisible(String xPath) {
        boolean displayed = false;
        displayed = getDriver().findElement(By.xpath(xPath)).isDisplayed() ;
        return displayed;
    }


    public static boolean elementWithXPathIsEnabled(String xPath) {
        boolean enabled;
        enabled= getDriver().findElement(By.xpath(xPath)).isEnabled() ;
        return enabled;
    }

        /*public static boolean lookForXpathInSearchResults(String xpath) throws Exception
        {
            boolean found = false;
            int page = 1;

            clickALink(SearchPage.itemsPerPage60);

            found = WebNavPage.elementWithXPathExists(xpath);

            Thread.sleep(3000);



            // if not found then goto next page
            while (!found) {
                

                String nextPage = "//a[contains(@href, 'page=" + page++ + "')]";

                if (WebNavPage.elementWithXPathExists(nextPage)) {

                    System.out.println("CLICKING NEXT PAGE - " + nextPage);

                    WebNavPage.clickALink(nextPage);
                    
                    try
                    {
                    WebNavPage.waitForElementToAppear(SearchPage.saveBTN);
                    }
                    catch (Exception e)
                    {
                      e.printStackTrace();
                    }

                      Thread.sleep(7000);

                    // check for value on next page
                    found = WebNavPage.elementWithXPathExists(xpath);

                    System.out.println("found status is - " + found);


                    if (found) {
                        break;  // success
                    }
                } else
                    break; // failure
            }

             return found;
        }*/




    public static void elementWithCssShouldBePresent(String css) {

        assertTrue(String.format("Element with %s should be present", css), getDriver().findElement(By.cssSelector(css)) != null);
    }

    public static Boolean assertContentExists(String xpath, String textToBePresent){

        String textToVerify = getText(xpath).toUpperCase();
        assertTrue("Expected Text Found"+"The text present was: "+textToVerify, textToVerify.contains(textToBePresent.toUpperCase()));

        return Boolean.TRUE;
    }

    public static boolean assertContentDoesNotExist(String xpath){

        try {
            getDriver().findElement(By.xpath(xpath));
            fail("Bleed Type drop down list exist ");
            return false;
        } catch (NoSuchElementException E){
            System.out.println("The Bleed Type drop down list is not present as expected");
            return true;
        }

    }

    public static void doRightClickAndSelectOption(String xpath){

        WebElement element = getDriver().findElement(By.xpath(xpath));
        Actions splUserAction = new Actions(getDriver());

        try {
            splUserAction.contextClick(element).perform();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static void assertContentDoesNotExistInTable(String Expected){

        WebElement element = getDriver().findElement(By.xpath("//div[@id='ctl00_body_gvList_custwindow_Scroller']/table"));
        List<WebElement> rowCollection = element.findElements(By.xpath("//div[@id='ctl00_body_gvList_custwindow_Scroller']/table/tbody/tr"));

        System.out.println("the number of Rows in that table is :"+rowCollection.size());
        Iterator<WebElement>ICounter = rowCollection.iterator();

        while (ICounter.hasNext()){
            WebElement row = ICounter.next();
            List<WebElement>columnElement = row.findElements(By.tagName("td"));
            Iterator<WebElement>colIterator = columnElement.iterator();
            while(colIterator.hasNext()){
                WebElement column = colIterator.next();
                System.out.println("The Value of the Row -"+ column.getText());
                String ActualRowName = column.getText();
                //Assert.assertFalse("The Value of the row does match with the expected",(ActualRowName.equalsIgnoreCase(Expected)== true));
                if (Expected.equalsIgnoreCase(ActualRowName)== true){
                    fail("The string "+Expected+"is present in the table ");
                    WebNavPage.clickALink("//div[@id='ctl00_body_gvList_custwindow_Scroller']/table/tbody/tr/td[contains(text(), 'OSI')]");
                }else{
                    //System.out.println("The Expected String is :"+Expected+"But the actuals string in the table is :"+ActualRowName);
                }
            }


        }
    }

    public static Boolean assertContentExists(String xpath){

        int CreRefNum = Integer.parseInt(WebNavPage.getText(xpath));
        System.out.print("the Value is " + CreRefNum);

        if (CreRefNum!=0){
            return true;
        } else {
            return false;
        }
    }

    public static boolean verifyCheckBoxChecked(String xpath){

        WebElement chkbox = getDriver().findElement(By.xpath(xpath));

        return chkbox.isSelected();

    }

    public static boolean verifyButtonEnabled (String xpath) {

        WebElement button = getDriver().findElement(By.xpath(xpath));
        assertTrue("the checkbox is selected", button.isEnabled());
        return true;

    }

    public static void moveSlider(String sliderXpath, int slidingUnits){

        WebElement sliderControl = getDriver().findElement(By.xpath(sliderXpath));
        Actions slider = new Actions(getDriver());
        Action moveSlider = slider.dragAndDropBy(sliderControl, slidingUnits, 0 ).build();
        moveSlider.perform();

    }

    public static void handleDialogPopUp(){
        Alert alert = getDriver().switchTo().alert();
        try{
            if (alert.getText()!= null){
                System.out.println(alert.getText());
                getDriver().findElement(By.id("userID")).sendKeys("demouser");
                getDriver().findElement(By.id("password")).sendKeys("Adpoint123");
                getDriver().switchTo().alert().accept();
                getDriver().switchTo().defaultContent();
                alert.accept();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String[] getElementsInList  (String element)
    {
        WebElement elmnt = getDriver().findElement(By.tagName("search-results list"));
        Select select = new Select(elmnt);
        select.selectByVisibleText("want this");
        String s[] = {"",""};
        return s;
    }

    public static void waitForElementToLoad(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public static void waitForShortSpan(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void selectingAnOptionFromList(String Option, String Xpath){

        Select selectRegion = new Select(getDriver().findElement(By.xpath(Xpath)));
        selectRegion.selectByVisibleText(Option);
    }

    public static String getSelectedOptionFromList(String xpath){
        Select selectRegion = new Select(getDriver().findElement(By.xpath(xpath)));
        String optionSelected = selectRegion.getFirstSelectedOption().getText();

        return  optionSelected;
    }

    public static void waitForElementToAppear(String elementlocator) throws InterruptedException {

        {
            for (int second = 0; ; second++)
            {
                if (second >= 10) Assert.fail("timeout");
                try
                {
                    if (elementWithXPathExists(elementlocator)) break;
                }catch (Exception e){
                    e. printStackTrace();
                }

                Thread.sleep(1000);

            }
        }
    }

    public static void waitForElementToBeVisible(String elementlocator) throws InterruptedException {

        {
            for (int second = 0; ; second++)
            {
                if (second >= 10) Assert.fail("timeout");
                try
                {
                    if (getDriver().findElement(By.xpath(elementlocator)).isDisplayed()) break;
                }catch (Exception e){
                    e. printStackTrace();
                }

                Thread.sleep(1000);

            }
        }
    }


    public static void waitForElementReady(String elementLocator) throws InterruptedException {

        {
            for (int second = 0; ; second++)
            {

                if (second >= 10) Assert.fail("timeout");
                try
                {
                    if (elementWithXPathExists(elementLocator))
                    {
                        if (elementWithXPathIsVisible(elementLocator))
                        {
                            if (elementWithXPathIsEnabled(elementLocator))
                            {
                                break  ;
                            }
                        }
                    }

                }catch (Exception e){
                    e. printStackTrace();
                }

                Thread.sleep(1000);

            }
        }
    }



    public static void closeBrowser(){
        getDriver().close();
    }

    public static void assertContentsExistInTableFirstRow(String xpath, Map<Integer,String> expected){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        List<WebElement> rowCollection = element.findElements(By.xpath(xpath + "/tbody/tr"));
        System.out.println("the number of Rows in that table is :"+rowCollection.size());
        Iterator<WebElement>ICounter = rowCollection.iterator();
        WebElement row = ICounter.next();
        assertContentsExistInTableRow(row,expected);
    }

    public static void assertContentsExistInTableEachRow(String xpath, Map<Integer,String> expected){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        List<WebElement> rowCollection = element.findElements(By.xpath(xpath + "/tbody/tr"));
        System.out.println("the number of Rows in that table is :"+rowCollection.size());
        Iterator<WebElement>ICounter = rowCollection.iterator();
        while(ICounter.hasNext()){
            WebElement row = ICounter.next();
            assertContentsExistInTableRow(row,expected);
        }
    }

    public static void assertTextExistInTableEachRow(String xpath, String expected){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        List<WebElement> rowCollection = element.findElements(By.xpath(xpath + "/tbody/tr"));
        System.out.println("the number of Rows in that table is :"+rowCollection.size());
        Iterator<WebElement>ICounter = rowCollection.iterator();
        while(ICounter.hasNext()){
            WebElement row = ICounter.next();
            assertTextExistsInTableRow(row,expected);
        }
    }
    public static Boolean assertTextExistsInTableRow(WebElement row, String textToBePresent){

        String textToVerify = row.getText().toUpperCase();
        System.out.println("The Text from the Xpath is : "+textToVerify);
        assertTrue("Expected Text Found", textToVerify.contains(textToBePresent.toUpperCase()));

        return Boolean.TRUE;
    }

    public static void assertContentsExistInTableRow(String xPath,int rowNumber ,Map<Integer,String> expected){
        WebElement element = getDriver().findElement(By.xpath(xPath));
        String rowxPath=xPath + "/tbody/tr[" + rowNumber + "]";
        System.out.println("The Value of the xPath -"+ rowxPath);
        WebElement row =element.findElement(By.xpath(rowxPath));
        assertContentsExistInTableRow(row,expected);
    }
    public static void assertContentsExistInTableRow(WebElement row,Map<Integer,String> expected){
        Map <Integer ,String> tableMap= new HashMap<Integer,String>();
        int counter=1;
        List<WebElement>columnElement = row.findElements(By.tagName("td"));
        Iterator<WebElement>colIterator = columnElement.iterator();
        while(colIterator.hasNext()){
            WebElement column = colIterator.next();
            System.out.println("The Value of the Row -"+ column.getText());
            tableMap.put(counter,column.getText());
            counter=counter+1;
            //Assert.assertFalse("The Value of the row does match with the expected",(ActualRowName.equalsIgnoreCase(Expected)== true));
        }
        System.out.println(expected);
        System.out.println(tableMap);

        Set<String> valuesSet=new HashSet<String>(expected.values());
        System.out.println(valuesSet);
        valuesSet.removeAll(tableMap.values());
        System.out.println(valuesSet);
        if( valuesSet.isEmpty()) {
            assertTrue("Content Exist is table row",true);
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
            fail("Expected values "+expected+"are not present in the table "+ tableMap);
        }
    }
    public static void rightClickOnTableElement(String xpath, String Linkxpath){
        rightClickTableFirstRow(xpath);
        clickALink(Linkxpath);
    }


    public static void rightClickTableFirstRow(String xpath){
        WebElement column=selectFirstRowOnTable(xpath);
        JavascriptLibrary js=new JavascriptLibrary();
        js.callEmbeddedSelenium(getDriver(), "triggerMouseEventAt", column,"contextmenu");
        waitForShortSpan();
    }
    public static WebElement selectFirstRowOnTable(String xpath){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        List<WebElement> rowCollection = element.findElements(By.xpath(xpath + "/tbody/tr"));
        Iterator<WebElement>ICounter = rowCollection.iterator();

        WebElement row = ICounter.next();
        List<WebElement>columnElement = row.findElements(By.tagName("td"));
        Iterator<WebElement>colIterator = columnElement.iterator();
        WebElement column = colIterator.next();
        column= colIterator.next();
        column.click();
        return column;
    }
    public static void rightClickTableRow(String xpath,int rowNumber){
        WebElement column=selectRowOnTable(xpath,rowNumber);
        JavascriptLibrary js=new JavascriptLibrary();
        js.callEmbeddedSelenium(getDriver(), "triggerMouseEventAt", column,"contextmenu");
        waitForShortSpan();

    }
    public static WebElement selectRowOnTable(String xpath,int rowNumber){
        WebElement element=getDriver().findElement(By.xpath(xpath + "/tbody/tr[" + rowNumber + "]/td[1]"));
        element.click();
        return element;
    }

    public static Boolean assertNoContentInTable(String xpath){

        String textToVerify = getText(xpath).toUpperCase();
        System.out.println("The Text from the Xpath is : "+textToVerify);
        assertTrue("Text Not Found", textToVerify.isEmpty());

        return Boolean.TRUE;
    }
    public static int findTableRowWithContent(String xPath, String[] tValueArray){
        WebElement element = getDriver().findElement(By.xpath(xPath));
        List<WebElement> rowCollection = element.findElements(By.xpath(xPath + "/tbody/tr"));
        Iterator<WebElement>ICounter = rowCollection.iterator();
        int rowNumber=0;
        int j=0;
        while (ICounter.hasNext() && rowNumber==0){
            j++;
            boolean sFlag=true;
            WebElement row = ICounter.next();
            String rowText = row.getText();
            int i=0;
            for(i=0; i < tValueArray.length; i++){
                if (!tValueArray[i].isEmpty()){
                    if (!rowText.contains(tValueArray[i])){
                        //	System.out.println(tValueArray[i] + "does not exist");
                        sFlag=false;
                    }
                }
            }
            if (sFlag==true){
                rowNumber=j;
                row.click();
                System.out.println(rowNumber);
            }
        }
        return rowNumber;
    }
    public static void assertDataExistInTable(String xpath){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        List<WebElement> rowCollection = element.findElements(By.xpath(xpath + "/tbody/tr"));
        System.out.println("the number of Rows in that table is :"+rowCollection.size());
        if (rowCollection.size()>0){
            assertTrue("Data Row Exist is table",true);
            System.out.println("Data Row Exist is table");
        }
        else {
            fail("No data displayed");
            System.out.println("No data displayed");
        }
    }

    public static void assertMenuLinkEnable(String xpath,String sLink){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        List<WebElement> sLinkCollection = element.findElements(By.xpath(xpath + "/div"));
        Iterator<WebElement>ICounter = sLinkCollection.iterator();
        boolean sLinkFound=false;
        while(ICounter.hasNext() && sLinkFound==false){
            WebElement sLinkObj = ICounter.next();
            if (sLink.equalsIgnoreCase(sLinkObj.getText())){
                String tmpAtt=sLinkObj.getAttribute("class");
                sLinkFound=true;
                if (!tmpAtt.contains("disabled")){
                    assertTrue("Link is enabled",true);
                    System.out.println(sLinkObj.getText() + "Link is enabled");

                }
                else {
                    fail("Link is disabled");
                    System.out.println(sLinkObj.getText() + "Link is disabled");
                }

            }

        }
    }
    public static void assertMenuLinkDisable(String xpath,String sLink){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        List<WebElement> sLinkCollection = element.findElements(By.xpath(xpath + "/div"));
        Iterator<WebElement>ICounter = sLinkCollection.iterator();
        boolean sLinkFound=false;
        while(ICounter.hasNext() && sLinkFound==false){
            WebElement sLinkObj = ICounter.next();
            if (sLink.equalsIgnoreCase(sLinkObj.getText())){
                String tmpAtt=sLinkObj.getAttribute("class");
                sLinkFound=true;
                if (tmpAtt.contains("disabled")){
                    assertTrue("Link is disable",true);
                    System.out.println(sLinkObj.getText() + "Link is disable");

                }
                else {
                    fail("Link is enabled");
                    System.out.println(sLinkObj.getText() + "Link is enabled");
                }

            }

        }
    }
    public static String[] getListItem(String xPath, String tagName ){
        WebElement element = getDriver().findElement(By.xpath(xPath));
        List<WebElement> sLinkCollection = element.findElements(By.xpath(xPath + "/" + tagName));
        Iterator<WebElement>ICounter = sLinkCollection.iterator();
        String[] Itemarr =new String[sLinkCollection.size()];
        int i=0;
        boolean sLinkFound=false;
        while(ICounter.hasNext()){
            WebElement sObj = ICounter.next();
            Itemarr[i]=sObj.getText();
            i++;
        }
        return Itemarr;
    }
    public static void MouseHover(String fieldLocator){

        WebElement element =  getDriver().findElement(By.xpath(fieldLocator));
        Actions builder=new Actions(getDriver());
        builder.moveToElement(element).build().perform();

    }
    public static void assertButtonDisable(String xpath){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        String tmpAtt=element.getAttribute("class");
        if (tmpAtt.contains("disabled")){
            assertTrue("Button is disable",true);
            System.out.println(element.getText() + "Button is disable");

        }
        else {
            fail("Link is enabled");
            System.out.println(element.getText() + "Button is enabled");
        }

    }
    public static void assertButtonEnable(String xpath){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        String tmpAtt=element.getAttribute("class");
        if (!tmpAtt.contains("disabled")){
            assertTrue("Button is enable",true);
            System.out.println(element.getText() + "Button is enable");

        }
        else {
            fail("Button is disabled");
            System.out.println(element.getText() + "Button is disabled");
        }

    }
    public static void assertEditTipExist(String xpath, String ColumnName){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        String tmpAtt=element.getAttribute("class");
        if (tmpAtt.contains("dirty-cell")){
            assertTrue("Column is marked as edited",true);
            System.out.println(ColumnName + "Column is marked as edited");

        }
        else {
            fail("Column is not marked as edited");
            System.out.println(ColumnName + "Column is not marked as edited");
        }

    }

}
