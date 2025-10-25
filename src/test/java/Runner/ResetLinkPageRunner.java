package Runner;

import Config.Setup;
import Util.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.resetLinkPage;

import java.io.IOException;


public class ResetLinkPageRunner extends Setup {
    resetLinkPage reset;
    WebElement emailInput;
    @BeforeMethod
    public void setUpPage() {
        reset = new resetLinkPage(driver);

    }
    @Test
    public void resetLink() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,400)");
        reset.clickReset();
        Thread.sleep(3000);
    }
    @Test
    public void invalidEmail() {
            //negative testcase 1
            emailInput = reset.txtemail;
            reset.submit("83473847");
            String actualText = emailInput.getAttribute("validationMessage");
            Assert.assertTrue(actualText.contains("Please include an '@'"),
                    "Expected validation message for invalid email, but got: " + actualText);
        }
        @Test
        public void emptyField()
        {
         //negative testcase 2
            emailInput = reset.txtemail;
        reset.submit("");
        String actualText1= emailInput.getAttribute("validationMessage");
        Assert.assertTrue(actualText1.contains("Please fill out this field"),
                "Expected validation message for empty email, but got: " + actualText1);

    }
    @Test
    public void validEmail() throws IOException, ParseException {

        emailInput = reset.txtemail;
        JSONObject obj= Utils.readJson("./src/test/resources/userData.json");
        String email=(String) obj.get("email");
        reset.submit(email);


    }
}

