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
import org.page_object.CompareList;
import org.page_object.WishList;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class CompareListStepDefinition {
    int randomNum;
    WebDriver driver;
    CompareList mCompareList;
    List<WebElement> all;
    int index;

    @Given("user  logged   in  successfuly")
    public void loginSuccessfuly() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mCompareList = new CompareList(driver);
        mCompareList.getLogIN().click();
        mCompareList.getEmail().sendKeys("most123@gmail.com");
        mCompareList.getPassword().sendKeys("most1234");
        mCompareList.getSubmit().click();
    }

    @When("user  select cell phones sub  category")
    public void selectCellPhoneSubCategory() throws InterruptedException {
        all = mCompareList.getCategoryList().findElements(By.tagName("li"));
        // {0, 4, 8, 12, 13, 14, 15}
        Actions action = new Actions(driver);
        action.moveToElement(all.get(4)).perform();
        Thread.sleep(1000);
        all.get(6).click();
    }

    @And("user add phone to compareList")
    public void AddPhoneToWishList() {
        mCompareList.getPhone1().click();
    }

    @And("user  select  books  category")
    public void selectBooksSubCategory() {
        mCompareList.getBookCategory().click();
    }

    @And("user add books to compareList")
    public void Add2BooksToWishList() throws InterruptedException {
        mCompareList.getBook1().click();
    }

    @And("user  select  Jewelry  category")
    public void selectJewelrySubCategory() {
        mCompareList.getJewelCategory().click();
    }

    @And("user  add Jewelry to compareList")
    public void Add2JewelryToCart() throws InterruptedException {
        mCompareList.getJewel1().click();
        mCompareList.getShoppingCartButton().click();
        Thread.sleep(1000);
    }

    @Then("list  of products added to compareList")
    public void listOfProductAppearInWishList() throws InterruptedException {

        String status = "fail";
        try {
            WebElement parentElement = mCompareList.getCartList();
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
