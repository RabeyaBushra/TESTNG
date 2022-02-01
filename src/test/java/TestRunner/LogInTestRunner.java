package TestRunner;

import Setup.Setup;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import pages.LogIn;

import java.io.IOException;

public class LogInTestRunner extends Setup {
    @Test
    public  void doUserLogin() throws InterruptedException, IOException, ParseException {
        LogIn login =new LogIn(driver);
        driver.get("http://automationpractice.com");
        Utils utils=new Utils(driver);
        utils.readJsonArray(0);
        String user= login.doLogin(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(user.contains("Test User"));
    }
    @Test
    public  void doLoginWithInvalidEmail() throws InterruptedException, IOException, ParseException {
        LogIn login =new LogIn(driver);
        driver.get("http://automationpractice.com");
        Utils utils=new Utils(driver);
        utils.readJsonArray(1);
        String errorMsg= login.LoginWithInvalidEmail(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(errorMsg.contains("Invalid email address."));
    }
    @Test
    public  void LoginWithWrongPassword() throws InterruptedException, IOException, ParseException {
        LogIn login =new LogIn(driver);
        driver.get("http://automationpractice.com");
        Utils utils=new Utils(driver);
        utils.readJsonArray(2);
        String errorPassMsg= login.LoginWithWrongPassword(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(errorPassMsg.contains("Authentication failed."));
    }
}
