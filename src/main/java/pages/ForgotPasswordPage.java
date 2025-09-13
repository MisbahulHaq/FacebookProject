package pages;

import base.AbstractPage;
import base.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class ForgotPasswordPage extends AbstractPage implements PageActions {

    private By emailOrPhoneField = By.id("identify_email");
    private By searchButton = By.name("did_submit");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailOrPhone(String input) {
        WebElement field = WaitUtils.waitForVisible(driver, emailOrPhoneField, 10);
        field.clear();
        field.sendKeys(input);
    }

    public void clickSearch() {
        WebElement searchBtn = WaitUtils.waitForClickable(driver, searchButton, 10);
        searchBtn.click();
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public boolean isPageLoaded() {
        return driver.findElement(emailOrPhoneField).isDisplayed();
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
