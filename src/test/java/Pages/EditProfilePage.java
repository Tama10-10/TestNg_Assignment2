package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EditProfilePage {
    @FindBy(tagName = "button")
    List<WebElement> editBtn;
    @FindBy(css = "[type='email']")
    public WebElement emailtxt;
    public EditProfilePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void editEmail(String email)
    {
        editBtn.get(1).click();
        emailtxt.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        emailtxt.sendKeys(email);

    }

}
