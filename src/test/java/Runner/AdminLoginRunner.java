package Runner;

import Config.Setup;
import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Util.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminLoginRunner extends Setup {
    @Test
    public void setLogin() throws IOException, ParseException, InterruptedException {
        LoginPage login=new LoginPage(driver);
        String adminEmail=System.getProperty("email");
        String password=System.getProperty("password");
        login.doLogin(adminEmail,password);
        AdminPage admin=new AdminPage(driver);
        Assert.assertTrue(admin.profileIcon.isDisplayed());
        Assert.assertEquals(admin.header.getText(),"Admin Dashboard");
        //DashboardPage dashboardPage=new DashboardPage(driver);
        Utils.getToken(driver);
        Thread.sleep(5000);
        //dashboardPage.logout();


    }
}
