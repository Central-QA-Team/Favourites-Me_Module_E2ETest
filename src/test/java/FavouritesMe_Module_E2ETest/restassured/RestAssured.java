package FavouritesMe_Module_E2ETest.restassured;

import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 18/06/12
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
public class RestAssured {

    private static String requestURL = "http://open.test.bbc.co.uk";
    private static Response response;
    private static String responseString = "";
    private static String contentType = "";
    private static boolean urlEncoding = true;
    private static int statusCode = 200;
    private static String rootPath = "";
    private static Map<String, String> requestHeaders = new HashMap<String, String>();
    private static Map<String, Object> responseHeaders = new HashMap<String, Object>();
    private static String requestBody = "";
    private static Map<String, Object> requestParams = new HashMap<String, Object>();
    private static ByteArrayOutputStream baosRequest = new ByteArrayOutputStream();
    private static PrintStream psRequest = new PrintStream(baosRequest);
    private static ByteArrayOutputStream baosResponse = new ByteArrayOutputStream();
    private static PrintStream psResponse = new PrintStream(baosResponse);
    private static RequestSpecification request;


    public static void clearDown() {
        //requestURL = "";

        response = null;
        responseString = "";
        contentType = "";
        rootPath = "";
        requestHeaders.clear();
        responseHeaders.clear();
        requestBody = "";
        requestParams.clear();
        baosResponse.reset();
        baosRequest.reset();
    }

    public RestAssured() {

    }

    private static RequestSpecification getRequest(){
        String proxy =  System.getProperty("Proxy");
        if(proxy.equals("true")){
            request = given().urlEncodingEnabled(urlEncoding).proxy("www-cache.reith.bbc.co.uk", 80);
        }
        else
            request = given().urlEncodingEnabled(urlEncoding);
        return request;
    }

    public static void setRequestURL(String url) {
        requestURL = url;
        System.out.println(requestURL);
    }

    public static String getRequestURL() {
         return requestURL;
    }

    public static void setRequestParams(String key, String value) {
        requestParams.put(key, value);
    }

    public static void appendURL(String append) {
        requestURL = requestURL + append;
        System.out.println(requestURL);
    }

    public static void setRequestBody(String body) {
        requestBody = body;
    }

   /* public static void setUsername(String userID){
        username = userID;
    }

    public static void setPassword(String pass){
        password = pass;
    }*/

    public static Response getResponse() {
        return response;
    }

    public static void performGetRequest() {

        try {
            response = given().urlEncodingEnabled(urlEncoding).headers(requestHeaders)
                    .filter(new RequestLoggingFilter(psRequest))
                    .filter(new ResponseLoggingFilter(psResponse))
                    .expect()
                    .statusCode(statusCode)
                    .headers(responseHeaders)
                    .get(requestURL);
            responseString = response.asString();

            //System.out.println(baosRequest.toString() + "\nResponse:\n" + baosResponse.toString());

        } catch(AssertionError e) {
            fail(e.getMessage() + "\n\n" + baosRequest.toString() + "\nResponse:\n" + baosResponse.toString());
        } finally {
            psRequest.close();
        }

    }

    public static void performPostRequest() {
        try {
            response = given().urlEncodingEnabled(urlEncoding).headers(requestHeaders)
                    .body(requestBody)
                    .filter(new RequestLoggingFilter(psRequest))
                    .filter(new ResponseLoggingFilter(psResponse))
                    .expect()
                    .statusCode(statusCode)
                    .headers(responseHeaders)
                    .post(requestURL);
            responseString = response.asString();
        } catch(AssertionError e) {
            fail(e.getMessage() + "\n\n" + baosRequest.toString() + "\nResponse:\n" + baosResponse.toString());
        } finally {
            psRequest.close();
        }

    }

    public static Response performRequest() {
        try {
            response = getRequest().headers(requestHeaders)
                    .body(requestBody)
                    .filter(new RequestLoggingFilter(psRequest))
                    .filter(new ResponseLoggingFilter(psResponse))
                    .cookie("IDENTITY","12345|||||")
                    .post(requestURL);
        } catch(AssertionError e) {
            fail(e.getMessage() + "\n\n" + baosRequest.toString() + "\nResponse:\n" + baosResponse.toString());
        } finally {
            psRequest.close();
        }
        return response;
    }

    public static void performPutRequest() {

        response = given().urlEncodingEnabled(urlEncoding).headers(requestHeaders)
                .body(requestBody)
                .expect().log().ifError()
                .statusCode(statusCode)
                .headers(responseHeaders)
                .put(requestURL);
        responseString = response.asString();
    }

    public static void setStatusCode(int code) {
        statusCode = code;

        if(code == 401) {
            // This header should be returned for all 401 errors
            setResponseHeader("WWW-Authenticate", "NowTV-SSO realm=\"nowtv.com\"");
        }
    }

    public static void setUrlEncoding(boolean urlEncode) {
        urlEncoding = urlEncode;
    }

    /**
     * Set additional Request Headers
     * @param key
     * @param value
     */
    public static void setRequestHeader(String key, String value) {
        requestHeaders.put(key, value);
    }

    public static String getRequestHeader(String key) {
        return requestHeaders.get(key);
    }

    public static void setAcceptJSON() {
        requestHeaders.clear();
        responseHeaders.clear();
        contentType = "application/json";
        requestHeaders.put("Accept", contentType);
        //requestHeaders.put("Content-Type", contentType);
        responseHeaders.put("Content-Type", containsString((String) requestHeaders.get("Accept")));
    }

    public static void setNewResponseHeader(){

        responseHeaders.clear();
    }

    public static void setAcceptXML() {
        requestHeaders.clear();
        responseHeaders.clear();
        contentType = "text/xml";
        requestHeaders.put("Accept", contentType);
        requestHeaders.put("Content-Type", contentType);
        responseHeaders.put("Content-Type", containsString((String) requestHeaders.get("Accept")));
    }

    public static void setAcceptMPODXML() {
        requestHeaders.clear();
        responseHeaders.clear();
        contentType = "text/mpod+xml";
        requestHeaders.put("Accept", contentType);
        requestHeaders.put("Content-Type", contentType);
        responseHeaders.put("Content-Type", containsString((String) requestHeaders.get("Accept")));
    }

    public static void setAcceptText() {
        requestHeaders.clear();
        responseHeaders.clear();
        contentType = "text/html";
        requestHeaders.put("Accept", contentType);
        requestHeaders.put("Content-Type", contentType);
        //responseHeaders.put("Content-Type", containsString((String) requestHeaders.get("Accept")));
    }

    public static void setAcceptUnknown() {
        requestHeaders.clear();
        responseHeaders.clear();
        contentType = "text/html";
        requestHeaders.put("Accept", "text/unknown");
    }

    /**
     * By default the response header will expect the content-type it requested to be returned
     * @param key
     * @param value
     */
    public static void setResponseHeader(String key, Object value) {
        responseHeaders.put(key, value);
    }

    public static String getResponseAsString() {
        return responseString;
    }

    public static String getString(String path) {
        if(contentType.contains("xml")) {
            return XmlPath.from(responseString).setRoot(rootPath).getString(path);
        }

        return JsonPath.from(responseString).setRoot(rootPath).getString(path);
    }

    public static int getInt(String path) {
        if(contentType.contains("xml")) {
            return XmlPath.from(responseString).setRoot(rootPath).getInt(path);
        }

        return JsonPath.from(responseString).setRoot(rootPath).getInt(path);
    }

    public static String getText(String path){
        if(contentType.contains("xml")){
            return XmlPath.from(responseString).setRoot(rootPath).getString(path);
        }
        return JsonPath.from(responseString).setRoot(rootPath).getString(path);
    }

    public static List<String> getList(String path) {
        if(contentType.contains("xml")) {
            return XmlPath.from(responseString).setRoot(rootPath).getList(path, String.class);
        }

        return JsonPath.from(responseString).setRoot(rootPath).getList(path, String.class);
    }

    public static Boolean getBoolean(String path) {
        if(contentType.contains("xml")) {
            return XmlPath.from(responseString).setRoot(rootPath).getBoolean(path);
        }

        return JsonPath.from(responseString).setRoot(rootPath).getBoolean(path);
    }

    public static void setRootPath(String path) {
        rootPath = path;
    }

    public static void validateAgainstXSD(String xsdPath) throws Exception {

        // 1. Lookup a factory for the W3C XML Schema language
        SchemaFactory factory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        // 2. Compile the schema.
        // Here the schema is loaded from a java.io.File, but you could use
        // a java.net.URL or a javax.xml.transform.Source instead.
        Schema schema = factory.newSchema(new File("/src/test/resources/cucumber/hotrod/java/resources" + xsdPath));

        // 3. Get a validator from the schema.
        Validator validator = schema.newValidator();

        // 4. Parse the document you want to check.
        Source source = new StreamSource(new StringReader(responseString));

        // 5. Check the document
        try {
            validator.validate(source);
        }
        catch (SAXException ex) {
            fail(requestURL + " failed validation becuase:\n\n" + ex.getMessage() + "\n");
        }
    }

//    public static void validateAgainstJSONSchema(String schemaPath) throws IOException, JsonValidationFailureException {
//
//        String WorkingDirectory = "C:/_Automation/QA-Automation/Hotrod-QA-Automation/src/test/resources/cucumber/hotrod/java/resources/"+schemaPath;
//
//        JsonValidator validator = new JsonValidator(fromFile(new File(WorkingDirectory)));
//
//        ValidationReport report = validator.validate(fromReader(new StringReader(responseString)));
//
//        StringBuilder errorReport = new StringBuilder();
//
//        for(String error : report.getMessages())  {
//            errorReport.append(error + "\n");
//        }
//
//        if(report.getMessages().size() > 0) {
//            fail(requestURL + " failed validation becuase:\n\n" + errorReport);
//        }
//
//    }



}
