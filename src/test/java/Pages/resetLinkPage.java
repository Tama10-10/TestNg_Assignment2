package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class resetLinkPage {
    @FindBy(css = "[href='/forgot-password']")
    WebElement resetLink;
    @FindBy(css="[type='email']")
    public WebElement txtemail;
    @FindBy(css="[type='submit']")
    WebElement submitBtn;
    public resetLinkPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void clickReset()
    {
        resetLink.click();
    }
    public void submit(String email)
    {
        txtemail.sendKeys(email);
        submitBtn.click();
    }
}

