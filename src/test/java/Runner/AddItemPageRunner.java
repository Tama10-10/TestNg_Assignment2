package Runner;

import Config.Setup;
import Config.itemModel;
import Pages.AddItemPage;
import Util.Utils;
import net.bytebuddy.build.Plugin;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class AddItemPageRunner extends Setup {
    @Test(priority = 1)
    public void addNewItem() throws ParseException, IOException, InterruptedException {
        Utils.setAuth(driver);
        Thread.sleep(3000);
        driver.get("https://dailyfinance.roadtocareer.net/user");
        AddItemPage itemPage=new AddItemPage(driver);
        itemModel item=new itemModel();
        item.setItemName("Pen");
        item.setAmountTxt("20");
        item.setDateTxt("12/12/2025");
        item.setRemarksTxt("No remarks for now");
        itemPage.additem(item);
         Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.accept();
        Assert.assertEquals(msg,"Product added successfully!");

    }
    @Test(priority = 2)
    public void addItemRequired() throws ParseException, IOException, InterruptedException {
        Utils.setAuth(driver);
        Thread.sleep(3000);
        driver.get("https://dailyfinance.roadtocareer.net/user");
        AddItemPage itemPage=new AddItemPage(driver);
        itemModel item=new itemModel();
        item.setItemName("Pencil");
        item.setAmountTxt("20");
//        item.setDateTxt("12/12/2025");
//        item.setRemarksTxt("No remarks for now");
        itemPage.additem(item);
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.accept();
        Assert.assertEquals(msg,"Product added successfully!");
        Thread.sleep(3000);
        String text=driver.findElements(By.tagName("span")).get(0).getText();
        Assert.assertEquals(text,"Total Rows: 2");
    }
}
