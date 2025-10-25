package Runner;

import Config.Setup;
import Pages.ResetPasswordPage;
import Services.GmailServices;
import Util.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResetPasswordRunner extends Setup {
    @Test
    public void setNewPassword() throws IOException, ParseException {
        GmailServices gmailServices = new GmailServices();
        String text = gmailServices.readLatestGmail();
        System.out.println(text);
        int start = text.indexOf("http");

        if (start != -1) {
            String url = text.substring(start);
            if (url.endsWith(".") || url.endsWith(",")) {
                url = url.substring(0, url.length() - 1);
            }
            driver.get(url);
            ResetPasswordPage reset=new ResetPasswordPage(driver);
            reset.setPassword("itstama");
            JSONObject obj= Utils.readJson("./src/test/resources/userData.json");
          obj.put("password","itstama");
            Utils.saveJSON("./src/test/resources/userData.json",obj);

        }


    }
}


