package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResetPasswordPage {
    @FindBy(tagName = "input")
    List<WebElement> passwordtxt;
    @FindBy(tagName ="button")
    WebElement submitBtn;
    public ResetPasswordPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void setPassword(String password)
    {
        passwordtxt.get(0).sendKeys(password);
        passwordtxt.get(1).sendKeys(password);
        submitBtn.click();
    }

}
