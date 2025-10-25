package Runner;

import Config.RegisterDataSet;
import Config.Setup;
import Config.UserModel;
import Pages.RegisterPage;
import Util.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class CsvRegisterRunnerPage extends Setup {
    @Test(dataProvider = "Registrationdata",dataProviderClass = RegisterDataSet.class)
    public void doRegister(String firstName,String lastName,String email,String password,String phoneNumber,String address) throws IOException, ParseException, InterruptedException {
        RegisterPage register = new RegisterPage(driver);
        register.regLink.get(1).click();
        UserModel user=new UserModel();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        register.doRegister(user);
        JSONObject obj=new JSONObject();
        obj.put("first name",firstName);
        obj.put("last name",lastName);
        obj.put("email",email);
        obj.put("password",password);

        Utils.saveJSON("./src/test/resources/userData.json",obj);
        Thread.sleep(7000);

    }
    }

