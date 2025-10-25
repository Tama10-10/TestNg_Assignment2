package Runner;

import Config.Setup;
import Config.itemModel;
import Pages.AddItemPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Util.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageRunner extends Setup {
    @Test
    public void userlogin() throws IOException, ParseException {
        LoginPage login=new LoginPage(driver);
        JSONObject obj= Utils.readJson("./src/test/resources/userData.json");
        String email=(String) obj.get("email");
        String password=(String)obj.get("password");
        login.doLogin(email,password);
        Utils.getToken(driver);
//        DashboardPage dashboardPage=new DashboardPage(driver);
//        dashboardPage.logout();
    }


}
