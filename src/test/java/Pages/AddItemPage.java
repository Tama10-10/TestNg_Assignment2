package Pages;

import Config.itemModel;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class AddItemPage {
    @FindBy(className = "add-cost-button")
    WebElement addBtn;
    @FindBy(id = "itemName")
    WebElement itemNametxt;
    @FindBy(css = "[type='button']")
    List<WebElement> QuantityBtn;
    @FindBy(id="amount")
    WebElement amountTxt;
    @FindBy(id = "purchaseDate")
    WebElement dateTxt;
    @FindBy(id="month")
    WebElement monthDropdwn;
    @FindBy(id="remarks")
    WebElement remarkTxt;
    @FindBy(tagName = "button")
    List<WebElement> submitBtn;
    public AddItemPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void additem(itemModel item) throws InterruptedException {
        addBtn.click();
        if (item.getItemName() != null && !item.getItemName().isEmpty()) {
            itemNametxt.sendKeys(item.getItemName());
        }
        //QuantityBtn.get(2).click();
        if (item.getAmountTxt() != null && !item.getAmountTxt().isEmpty()){
        amountTxt.sendKeys(item.getAmountTxt());}
        if (item.getDateTxt() != null && !item.getDateTxt().isEmpty())
        {
        dateTxt.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        dateTxt.sendKeys(item.getDateTxt());}
        //dateTxt.sendKeys(Keys.ENTER);
        Select select=new Select(monthDropdwn);
        select.selectByVisibleText("January");
        if (item.getRemarksTxt() != null && !item.getRemarksTxt().isEmpty())
        {
        remarkTxt.sendKeys(item.getRemarksTxt());}
        submitBtn.get(3).click();
         Thread.sleep(3000);




    }
}
