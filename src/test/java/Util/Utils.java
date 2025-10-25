package Util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class Utils {
    public static int generateRandomNumber(int min,int max)
    {
        double random=Math.random()*(max-min)+min;
        return (int)random;
    }
    public static void saveJSON(String path, JSONObject object) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONArray jsonArray=(JSONArray)parser.parse(new FileReader(path));
        jsonArray.add(object);
        FileWriter writer=new FileWriter(path);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }
    public static JSONObject readJson(String path) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONArray jsonArray=(JSONArray) parser.parse(new FileReader(path));
        JSONObject obj=(JSONObject) jsonArray.get(jsonArray.size()-1);
        return obj;
    }
    public static JSONObject readPreviousJson(String path) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONArray jsonArray=(JSONArray) parser.parse(new FileReader(path));
        JSONObject obj=(JSONObject) jsonArray.get(jsonArray.size()-2);
        return obj;
    }
    public static void getToken(WebDriver driver) throws IOException {
        //wait until the authToken is available
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until((ExpectedCondition<Boolean>) wd -> js.executeScript("return window.localStorage.getItem('authToken')") != null);

        //get the authToken from the localstorage
        String authToken = (String) js.executeScript("return window.localStorage.getItem('authToken');");
        String authTokenData=(String) js.executeScript("return window.localStorage.getItem('authTokenData');");
        System.out.println("Auth Token Retrieved: " + authToken);
        System.out.println("Auth Token Retrieved: " + authTokenData);

        // Save the auth token to a localstorage.json file
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("authToken", authToken);
        jsonObject.put("authTokenData", authTokenData);
        FileWriter writer=new FileWriter("./src/test/resources/localstorage.json");
        writer.write(jsonObject.toJSONString());
        writer.flush();
        writer.close();
    }
    public static void setAuth(WebDriver driver) throws ParseException, InterruptedException, IOException {
        JSONParser jsonParser=new JSONParser();
        JSONObject authObj= (JSONObject) jsonParser.parse(new FileReader( "./src/test/resources/localstorage.json"));
        String authToken= authObj.get("authToken").toString();
        String authTokenData= authObj.get("authTokenData").toString();
        System.out.println(authToken);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.setItem('authToken', arguments[0]);", authToken);
        js.executeScript("window.localStorage.setItem('authTokenData', arguments[0]);", authTokenData);
        Thread.sleep(2000);
    }


}

