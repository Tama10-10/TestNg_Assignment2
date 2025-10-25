package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    @FindBy(tagName = "svg")
    WebElement profileIcon;
    @FindBy(css = "[role='menuitem']")
    List<WebElement>menu;
    public DashboardPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void logout()
    {
        profileIcon.click();
        menu.get(1).click();
    }
    public void profile()
    {
        profileIcon.click();
        menu.get(0).click();
    }
}

