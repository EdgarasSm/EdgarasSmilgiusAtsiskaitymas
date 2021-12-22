package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public By topLink = By.cssSelector("#top-links .dropdown");
    public By menu = By.cssSelector("#top-links .dropdown");
    public By option = By.partialLinkText("Login");
    public By navigationButton = By.linkText("MP3 Players");

    public WebElement SelectedNavigationButton () {
        return driver.findElement(navigationButton);
    }



}
