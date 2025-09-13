package pages;

import base.AbstractPage;
import base.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class LoginPage extends AbstractPage implements PageActions {

    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButton = By.name("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        WebElement emailEle = WaitUtils.waitForVisible(driver, emailField, 10);
        emailEle.clear();
        emailEle.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passEle = WaitUtils.waitForVisible(driver, passwordField, 10);
        passEle.clear();
        passEle.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = WaitUtils.waitForClickable(driver, loginButton, 10);
        loginBtn.click();
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public boolean isPageLoaded() {
        return driver.findElement(loginButton).isDisplayed();
    }

    @Override
    public void openPage(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
