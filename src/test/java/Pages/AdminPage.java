package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
        @FindBy(tagName = "svg")
        public WebElement profileIcon;
        @FindBy(tagName = "h2")
        public WebElement header;
        @FindBy(className = "search-box")
        public WebElement searchBox;
        @FindBy(tagName = "tbody")
        public WebElement table;
        public AdminPage(WebDriver driver)
        {
            PageFactory.initElements(driver,this);
        }
    }


