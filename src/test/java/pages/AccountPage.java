package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public By blockName = By.tagName("h2");
    public By emailInput = By.id("input-email");
    public By passInput = By.id("input-password");
    public By submitButton = By.cssSelector("input[type='submit']");
    public By alertMessage = By.className("alert");

    public WebElement getEmailInput() {
        return driver.findElement(emailInput);
    }

    public WebElement passwordInput() {
        return driver.findElement(passInput);
    }

    public WebElement submitButton() {
        return driver.findElement(submitButton);
    }

    public WebElement getAlertMessage() {
        return driver.findElement(alertMessage);
    }



}
