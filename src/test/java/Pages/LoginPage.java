package Pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "password")
    WebElement txtPass;
    @FindBy(css = "[type='submit']")
    WebElement btnSubmit;
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void doLogin(String email,String password)
    {   txtEmail.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        txtEmail.sendKeys(email);
        txtPass.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        txtPass.sendKeys(password);
        btnSubmit.click();
    }
}

