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

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GetAllUserRunner extends Setup {
    @Test
    public void getAllUser() throws ParseException, IOException, InterruptedException {
        Utils.setAuth(driver);
        Thread.sleep(3000);
        driver.get("https://dailyfinance.roadtocareer.net/admin");
        AdminPage adminPage = new AdminPage(driver);
        FileWriter writer=new FileWriter("./src/test/resources/allUsers.txt",true);
        List<WebElement>rows=adminPage.table.findElements(By.tagName("tr"));
        for(WebElement row:rows)
        {
            List<WebElement>cells=row.findElements(By.tagName("td"));
            for(WebElement cell:cells)
            {
                System.out.println(cell.getText());
                writer.write(cell.getText()+" ");
            }
            writer.write("\n");
        }
        writer.flush();
        writer.close();


    }
}
