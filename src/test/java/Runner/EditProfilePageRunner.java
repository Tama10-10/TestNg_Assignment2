package Runner;

import Config.Setup;
import Pages.DashboardPage;
import Pages.EditProfilePage;
import Pages.LoginPage;
import Util.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditProfilePageRunner extends Setup {
    @Test(priority=1)
    public void EditProfile() throws ParseException, IOException, InterruptedException {
        Utils.setAuth(driver);
        Thread.sleep(3000);
        driver.get("https://dailyfinance.roadtocareer.net/user");
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.profile();
        EditProfilePage editProfilePage=new EditProfilePage(driver);
        //System.out.println(editProfilePage.emailtxt.getAttribute("value"));
        editProfilePage.editEmail("tamadebnath2001+"+ Utils.generateRandomNumber(1000,9999)+"@gmail.com");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,200)");
        driver.findElements(By.tagName("button")).get(2).click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        alert.accept();
        JSONObject obj= Utils.readJson("./src/test/resources/userData.json");
        obj.put("email",editProfilePage.emailtxt.getAttribute("value"));
        Utils.saveJSON("./src/test/resources/us" +
                "erData.json",obj);

        dashboardPage.logout();

    }
    @Test(priority=2)
    public void loginWithUpdatedEmail() throws IOException, ParseException {
        LoginPage login=new LoginPage(driver);
        JSONObject obj= Utils.readJson("./src/test/resources/userData.json");
        String email=(String) obj.get("email");
        String password=(String)obj.get("password");
        login.doLogin(email,password);
        String text=driver.findElement(By.className("css-173147z-MuiTypography-root")).getText();
        Assert.assertEquals(text,"Dashboard");
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.logout();
    }
    @Test(priority = 3)
    public void loginWithPreviousEmail() throws IOException, ParseException {
        LoginPage login=new LoginPage(driver);
        JSONObject obj= Utils.readPreviousJson("./src/test/resources/userData.json");
        String email=(String) obj.get("email");
        String password=(String)obj.get("password");
        login.doLogin(email,password);
        String text=driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(text,"Invalid email or password");

    }
}
