package Services;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GmailServices {
    Properties prop;
    public GmailServices() throws IOException {
        prop=new Properties();
        FileInputStream fs=new FileInputStream("./src/test/resources/config.properties");
        prop.load(fs);
    }
    public String getGmailList() throws IOException {

        RestAssured.baseURI="https://gmail.googleapis.com";
        Response res=given().contentType("application/json").header("Authorization","Bearer "+prop.getProperty("token")).when().get("/gmail/v1/users/me/messages");
        JsonPath jsonobj=res.jsonPath();
        String listId=jsonobj.get("messages[0].id");
        return listId;

    }
    public String readLatestGmail() throws IOException {
        GmailServices gmail=new GmailServices();
        String id=gmail.getGmailList();
        //System.out.println(id);
        RestAssured.baseURI="https://gmail.googleapis.com";
        Response res=given().contentType("application/json").header("Authorization","Bearer "+prop.getProperty("token")).when().get("/gmail/v1/users/me/messages/"+id);
        JsonPath jsonobj=res.jsonPath();
        String msg=jsonobj.get("snippet");
        return msg;

    }
    public static void main(String[] args) throws IOException {
        GmailServices gmail=new GmailServices();
        String msg=gmail.readLatestGmail();
        System.out.println(msg);
    }
}

