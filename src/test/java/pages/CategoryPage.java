package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage {
    public WebDriver driver;

    public CategoryPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public By showAll = By.linkText("Show All MP3 Players");
    public By allList = By.id("list-view");

    public WebElement showAllProduct() {
        return driver.findElement(showAll);
    }

    public WebElement showAllInList () {
        return driver.findElement(allList);
    }








}
