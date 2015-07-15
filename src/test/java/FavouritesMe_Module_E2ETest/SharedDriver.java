package FavouritesMe_Module_E2ETest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.LoggerFactory;
import util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 29/03/12
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class SharedDriver extends WebDriverException {

    private static WebDriver driver;
    private static ChromeDriverService _chrome;
    private static DesiredCapabilities _capabilities;
    public static String directory = System.getProperty("user.dir");
    private static String drivers = directory + File.separator + "src" + File.separator + "test"
            + File.separator + "resources" + File.separator + "drivers";
    private static String phantomJsDriver = directory + File.separator + "src" + File.separator + "test"
            + File.separator + "resources" + File.separator + "drivers";
    private static String phantomJsDriver4Linux = directory + File.separator + "target"
            + File.separator + "phantomJs" + File.separator + "phantomjs-1.9.1-linux-x86_64"
            + File.separator + "bin";
    private static String phantomJsDriver4macOSx =  directory + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "drivers"
            + File.separator + "phantomJs" + File.separator + "macOSx" + File.separator + "phantomjs-macosx" + File.separator +
            "bin";
    private static final String FIREFOX_LOCATION="/Applications/Firefox.app/Contents/MacOS/firefox";
    private static final String CHROME_LOCATION="/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
    private static final String CONFIG = "browser.config";
    //private static final File FIREFOX_LOCATION = new File (getConfigFile().getProperty("firefox.path"));
    //private static final String CHROME_LOCATION= getConfigFile().getProperty("chrome.path");

    private static String browserCapabilities = capabilities();
    String getSessionId;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SharedDriver.class);

    public static String capabilities(){
        String capabilities = System.getProperty("capabilities");
        String key = "safari";    //user agent;
        if (key.equalsIgnoreCase("firefox")) {
            return "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0";
        } else if (key.equalsIgnoreCase("chrome")) {
            return "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36";
        } else if (key.equalsIgnoreCase("opera")) {
            return "Opera/9.80 (X11; Linux i686; Ubuntu/14.10) Presto/2.12.388 Version/12.16";
        } else if (key.equalsIgnoreCase("safari")) {
            return "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.75.14 (KHTML, like Gecko) Version/7.0.3 Safari/7046A194A";
        } else if (key.equalsIgnoreCase("IE11")){
            return "Mozilla/5.0 (compatible, MSIE 11, Windows NT 6.3; Trident/7.0; rv:11.0) like Gecko";
        } else if (key.equalsIgnoreCase("IE9")){
            return "Mozilla/5.0 (Windows; U; MSIE 9.0; WIndows NT 9.0; en-US))";
        } else {
            return "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0";
        }

    }


    public static Properties getConfigFile() {
        Properties browserLocation = null;
        try {
            browserLocation = FileUtils.getProperties(CONFIG);
        } catch (IOException fnf) {
            logger.error("ERROR LOADING CONFIG FILE");
        }
        return browserLocation;
    }


    @Before("~@noWebDriver")
    public static void setUp() throws Exception {
        String browser = System.getProperty("browser");
        String key = "firefox";    //browser;
        System.out.println("The Operating system used is: " + System.getProperty("os.name").toLowerCase());
        System.out.println("The Browser used is: " + key);
        if (key.equalsIgnoreCase("chrome")) {
            setChromeDriver();
        } else if (key.equalsIgnoreCase("firefox")) {
            setFirefoxDriver();
        } else if (key.equalsIgnoreCase("phantomJs")) {
            setPhantomJs();
        } else {
            setInternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @SuppressWarnings("finally")
    public static WebDriver getDriver() {


        if (driver == null) {
            throw new IllegalStateException("Selenium client is not initialised.");
        }
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            return driver.switchTo().defaultContent();
        }

    }

    public static void setFirefoxDriver() {


        //_capabilities = DesiredCapabilities.firefox();
        FirefoxProfile _profile = new FirefoxProfile();
        File f = new File(FIREFOX_LOCATION);
        FirefoxBinary _ffbinary = new FirefoxBinary(f);
        //_profile.setPreference("network.proxy.type", 1);
        //_profile.setPreference("network.proxy.http", "www-cache.reith.bbc.co.uk");
        //_profile.setPreference("network.proxy.http_port", 80);
        //_profile.setPreference("network.proxy.ssl", "www-cache.reith.bbc.co.uk");
        //_profile.setPreference("network.proxy.ssl_port", 80);
        driver = new FirefoxDriver(_ffbinary, _profile);
    }
        
    /*public static void setChromeDriver(){

        String OSIAmIn = System.getProperty("os.name").toLowerCase();
        System.out.println("The OS i am using is :"+OSIAmIn);
             
        
        if (OSIAmIn.contains("windows")){
            _chrome = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(drivers +File.separator+"win" + File.separator + "chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();

            try {
                _chrome.start();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            _capabilities = DesiredCapabilities.chrome();
            _capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
            Proxy proxy = new Proxy();
            proxy.setProxyType(Proxy.ProxyType.SYSTEM);
            driver = new RemoteWebDriver(_chrome.getUrl(), _capabilities);
           
            


            
         This is intentionally commented    
            
        }else if (OSIAmIn.contains("linux")){
            _chrome = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(drivers +File.separator+"linux"))
                    .usingPort(9515)
                    .build();
            //.usingDriverExecutable(new File(drivers +File.separator+"linux" + File.separator + "chromedriver"))
        
            HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_17);
            driver.setJavascriptEnabled(true);
         This is intentionally commented 

        }


        //ChromeOptions options = new ChromeOptions();
    }

    public static kid setPhantomjsDriver(){
    	
    	caps = new DesiredCapabilities();
    
    	
    	
    }*/

    public static void setChromeDriver() {
        String OSIAmIn = System.getProperty("os.name").toLowerCase();
        if (OSIAmIn.contains("windows")) {
            System.setProperty("webdriver.chrome.driver", drivers + File.separator + "chromedriver" + File.separator  + "win" + File.separator  + "chromedriver.exe");
        } else if(OSIAmIn.contains("mac os x")) {
            System.setProperty("webdriver.chrome.driver", drivers + File.separator + "chromedriver" + File.separator  + "mac" + File.separator  + "chromedriver");
        }

        //System.setProperty("webdriver.chrome.driver", drivers + File.separator + "chromedriver" + File.separator  + "win" + File.separator  + "chromedriver.exe");
        ChromeOptions browser_setup = new ChromeOptions();
        browser_setup.setBinary(new File(CHROME_LOCATION));
        driver = new ChromeDriver(browser_setup);

    }


    public static void setPhantomJs() {

        String OSIAmIn = System.getProperty("os.name").toLowerCase();
        System.out.println("The OS i am using is :" + OSIAmIn);

        _capabilities = DesiredCapabilities.phantomjs();
        _capabilities.setJavascriptEnabled(true);
        _capabilities.setCapability("takesScreenshot", true);
        _capabilities.setCapability("phantomjs.page.settings.userAgent", browserCapabilities);

        if (OSIAmIn.contains("windows")) {
            _capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, drivers + File.separator + "phantomJs" + File.separator + "phantomjs.exe");
        } else if(OSIAmIn.contains("mac os x")) {
            _capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJsDriver4macOSx + File.separator + "phantomjs");
        }


        try {
            driver = new PhantomJSDriver(_capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void setInternetExplorerDriver() {

        _capabilities = DesiredCapabilities.internetExplorer();
        _capabilities.setCapability("ignoreProtectedModeSettings", true);

        driver = new InternetExplorerDriver(_capabilities);
    }

    /*public static void setSafariDriver(){

        _capabilities = DesiredCapabilities.safari();
        driver = new SafariDriver(_capabilities);

    }*/


    private void saveSessionIdToSomeStorage(String session) {

    }

    private String getPreviousSessionIdFromStorage() {
        return getSessionId;
    }


    @After
    public static void close(Scenario scenario) {

    	/*StringBuffer verificationErrors = new StringBuffer();
        System.out.println("hello, I'm running closeBrowser");
        if (driver != null) {
            if (_capabilities.getBrowserName().equalsIgnoreCase("chrome")){
               if (scenario.isFailed()){
                    driver = new Augmenter().augment(driver);
                    try {
                        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        scenario.embed(screenshot, "image/png");
                    } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                        System.out.println("the screenshot embed failed !!");
                        System.err.println(somePlatformsDontSupportScreenshots.getMessage());
                    }
                }
                _chrome.stop();

            } else {
            	if (_capabilities.getBrowserName().equalsIgnoreCase("phantomJs")) {
			    if (scenario.isFailed()){
			    	System.out.println("Verifying i went here");


			    	try {

                    	System.out.println("I am entering here ");
                    	driver = new Augmenter().augment(driver);
                    	System.out.println("Did Error happen here ?? ");
                    	byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        scenario.embed(screenshot, "image/png");

                    } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                        System.out.println("the screenshot embed failed !!");
                        System.err.println(somePlatformsDontSupportScreenshots.getMessage());
                        driver.quit();

                }
            	}
                    driver.quit();
            }

            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

    }
    */
        StringBuffer verificationErrors = new StringBuffer();
        if (scenario.isFailed()) {
            try {

                System.out.println("I am entering here ");
                //driver = new Augmenter().augment(driver);
                System.out.println("Did Error happen here ?? ");
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");

            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.out.println("the screenshot embed failed !!");
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());


            }
        }
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
        driver.quit();


    }

}


