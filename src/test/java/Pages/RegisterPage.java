package Pages;



import Config.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage {
    @FindBy(tagName = "a")
    public List<WebElement> regLink;
    @FindBy(id = "firstName")
    WebElement firstname;
    @FindBy(id = "lastName")
    WebElement lastname;
    @FindBy(id="email")
    WebElement txtemail;
    @FindBy(id="password")
    WebElement txtpassword;
    @FindBy(id="phoneNumber")
    WebElement Number;
    @FindBy(id = "address")
    WebElement txtaddress;
    @FindBy(css = "[type='radio']")
    List<WebElement> radioBtn;
    @FindBy(css = "[type='checkbox']")
    WebElement check;
    @FindBy(id = "register")
    WebElement regBtn;

    public RegisterPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void doRegister(UserModel user) throws InterruptedException {
        firstname.sendKeys(user.getFirstName());
        lastname.sendKeys(user.getLastName());
        txtemail.sendKeys(user.getEmail());
        txtpassword.sendKeys(user.getPassword());
        Number.sendKeys(user.getPhoneNumber());
        txtaddress.sendKeys(user.getAddress());
        radioBtn.get(0).click();
        check.click();
        regBtn.click();

    }
}

