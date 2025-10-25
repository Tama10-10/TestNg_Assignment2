package Runner;

import Config.Setup;
import Pages.AdminPage;
import Util.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SearchUserRunner extends Setup {
    @Test
    public void searchUser() throws IOException, ParseException, InterruptedException {
        Utils.setAuth(driver);
        Thread.sleep(3000);
        driver.get("https://dailyfinance.roadtocareer.net/admin");
        AdminPage adminPage = new AdminPage(driver);
        JSONObject obj = Utils.readJson("./src/test/resources/userData.json");
        String email = (String) obj.get("email");
        adminPage.searchBox.sendKeys(email);
        List<WebElement>rows=adminPage.table.findElements(By.tagName("tr"));

        List<WebElement>data=rows.get(0).findElements(By.tagName("td"));
        String text=data.get(2).getText();
        Assert.assertEquals(text,email);

    }
}