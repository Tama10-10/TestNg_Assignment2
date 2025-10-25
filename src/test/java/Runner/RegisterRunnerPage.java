package Runner;



import Services.GmailServices;
import Util.Utils;
import com.github.javafaker.Faker;
import Config.Setup;
import Config.UserModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.RegisterPage;

import java.io.IOException;


public class RegisterRunnerPage extends Setup {
    @Test
    public void setRegister() throws IOException, InterruptedException, ParseException {
        RegisterPage register = new RegisterPage(driver);
        GmailServices gmailServices=new GmailServices();
        register.regLink.get(1).click();
        Faker faker=new Faker();
        String fname = faker.name().firstName();
        String lname= faker.name().lastName();
        String email="tamadebnath2001+"+ Utils.generateRandomNumber(1000,9999)+"@gmail.com";
        String password="1234";
        String number="0130"+ Utils.generateRandomNumber(1000000,9999999);
        String address=faker.address().fullAddress();
        UserModel user=new UserModel();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(number);
        user.setAddress(address);
        register.doRegister(user);
        JSONObject obj=new JSONObject();
        obj.put("first name",fname);
        obj.put("last name",lname);
        obj.put("email",email);
        obj.put("password",password);

        Utils.saveJSON("./src/test/resources/userData.json",obj);
        Thread.sleep(5000);
        String text=gmailServices.readLatestGmail();
        System.out.println(text);
        Assert.assertTrue(text.contains("Welcome to our platform!"));

    }
}
