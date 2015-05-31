package acceptance;

/**
 * Created with IntelliJ IDEA.
 * User: chelln01
 * Date: 28/04/15
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */

import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"pretty", "html:target/cucumber-report", "json:target/cucumber-report.json"},
        features = {"classpath:acceptance/feature"},
        glue = {"FavouritesMe_Module_E2ETest"},
        tags = {"@web"},
        strict = true)
public class AcceptanceITCase {

}