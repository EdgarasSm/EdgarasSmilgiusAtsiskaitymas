package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CategoryPage;


import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddToCartTest extends BaseTest {

    BasePage basePage = new BasePage(driver);
    CategoryPage categoryPage = new CategoryPage(driver);

    String product;

    @Factory(dataProvider = "addToCartFunctionality")
    public AddToCartTest(String product) {
        this.product = product;
    }


    @DataProvider(name = "addToCartFunctionality")
    public static Object[][] data() {
        return new Object[][]{
                {"iPod Nano"},
                {"iPod Touch"},
                {"iPod Shuffle"},
        };
    }

    @Test(priority = 1)
    public void clickOnNavigationBar() {
        basePage.SelectedNavigationButton().click();

    }

    @Test(priority = 2)
    public void selectShowAll() {
        categoryPage.showAllProduct().click();
    }

    @Test(priority = 3)
    public void checkCategoryTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "MP3 Players";
        assertEquals(actualTitle, expectedTitle, "Title doesn't match, check again");
    }

    @Test(priority = 4)
    public void makeProductsVisibleInList() {
        categoryPage.showAllInList().click();
    }

    @Test(priority = 5) // Neveikia šita... :/
    public void findProduct(String product) throws InterruptedException {
        List<WebElement> ipods = driver.findElements(By.cssSelector("h4 a"));
        WebElement expectedProduct = ipods.stream()
                .filter(ipod -> ipod.getText().contains(product)).findFirst().get();
        Actions action = new Actions(driver);
        action.moveToElement(expectedProduct).perform();
        Thread.sleep(4000);
    }
}
