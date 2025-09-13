package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import utils.RetryAnalyzer;

@Listeners(utils.TestListener.class)
public class ForgotPasswordTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testForgotPasswordFlow() {
        test = extent.createTest("Facebook Forgot Password Test");

        ForgotPasswordPage forgotPage = new ForgotPasswordPage(driver);
        forgotPage.openPage("https://www.facebook.com/login/identify/");
        Assert.assertTrue(forgotPage.isPageLoaded(), "Forgot password page not loaded");

        forgotPage.enterEmailOrPhone("testuser@gmail.com");
        forgotPage.clickSearch();

        test.log(Status.INFO, "Page title: " + forgotPage.getPageTitle());
    }
    @Test
    public void test1()
    {
    	System.out.println("hello");
    }
}
