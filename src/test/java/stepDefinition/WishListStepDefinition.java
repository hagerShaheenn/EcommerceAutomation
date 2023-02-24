package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.page_object.ShoppingCart;
import org.page_object.WishList;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class WishListStepDefinition {
    int randomNum;
    WebDriver driver;
    WishList mWishList;
    List<WebElement> all;
    int index;

    @Given("user  logged  in  successfuly")
    public void loginSuccessfuly() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        mWishList = new WishList(driver);
        mWishList.getLogIN().click();
        mWishList.getEmail().sendKeys("most123@gmail.com");
        mWishList.getPassword().sendKeys("most1234");
        mWishList.getSubmit().click();
    }

    @When("user select cell phones sub  category")
    public void selectCellPhoneSubCategory() throws InterruptedException {
        all = mWishList.getCategoryList().findElements(By.tagName("li"));
        // {0, 4, 8, 12, 13, 14, 15}
        Actions action = new Actions(driver);
        action.moveToElement(all.get(4)).perform();
        Thread.sleep(1000);
        all.get(6).click();
    }

    @And("user add phone to wishlist")
    public void AddPhoneToCart() {
        mWishList.getPhone1().click();
    }

    @And("user select  books  category")
    public void selectBooksSubCategory() {
        mWishList.getBookCategory().click();
    }

    @And("user add books to wishlist")
    public void Add2BooksToCart() throws InterruptedException {
        mWishList.getBook1().click();
    }

    @And("user  select  Jewelry category")
    public void selectJewelrySubCategory() {
        mWishList.getJewelCategory().click();
    }

    @And("user  add Jewelry to wishlist")
    public void Add2JewelryToCart() throws InterruptedException {
        mWishList.getJewel1().click();
    }

    @Then("list  of products added to wishlist")
    public void listOfProductAppearInShoppingCart() throws InterruptedException {
        mWishList.getShoppingCartButton().click();
        Thread.sleep(1000);
        String status = "fail";
        try {
            WebElement parentElement = mWishList.getCartList();
            List<WebElement> allChildElements = parentElement.findElements(By.xpath("*"));
            int size = allChildElements.size();
            if (size > 0)
                status = "pass";
        } catch (Exception e) {
        }
        Assert.assertEquals("pass", status);
    }

    @After
    public void clouser() {
        try {
            driver.quit();
        } catch (Exception e) {
        }
    }
}
