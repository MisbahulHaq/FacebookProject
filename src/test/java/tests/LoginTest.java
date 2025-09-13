package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.RetryAnalyzer;

@Listeners(utils.TestListener.class)
public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testFacebookLogin() {
        test = extent.createTest("Facebook Login Test");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("https://www.facebook.com/");
        loginPage.enterEmail("invalidUser");
        loginPage.enterPassword("invalidPass");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page not loaded properly");
        test.log(Status.INFO, "Page title: " + loginPage.getPageTitle());
    }
}
