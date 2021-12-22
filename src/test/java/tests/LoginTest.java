package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.BasePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {
    BasePage basePage = new BasePage(driver);
    AccountPage accountPage = new AccountPage(driver);

    @Test(priority = 1)
    public void clickOnTopSelectedLink() {
        driver.findElement(basePage.topLink).click();
    }

    @Test(priority = 2)
    public void clickOnDropdownLoginButton() {
        WebElement dropdown = driver.findElement(basePage.menu);
        dropdown.findElement(basePage.option).click();
    }

    @Test(priority = 3)
    public void checkNewCustomerBlockIsVisible() {
        boolean blockName = driver.findElement(accountPage.blockName).isDisplayed();
        assertTrue(blockName, "Block is not displayed");

    }

    @Test(priority = 4)
    public void enterEmailPasswordAndClickLogin() {
        accountPage.getEmailInput().sendKeys("testas@gmail.com");
        accountPage.passwordInput().sendKeys("12345");
        accountPage.submitButton().click();
    }

    @Test(priority = 5)
    public void checkAlertMessageIsVisible() {
        String actualAlertText = accountPage.getAlertMessage().getText();
        String expectedAlertText = "Warning: No match for E-Mail Address and/or Password.";
        assertEquals(actualAlertText,expectedAlertText,"Ooops something wrong with alert");
    }


}
