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
import org.page_object.Category;
import org.page_object.Search;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class CategoryStepDefinition {
    int randomNum;
    WebDriver driver;
    Category mCategory;
    List<WebElement> all;
    int index;

    @Given("user logged in  successfuly")
    public void loginSuccessfuly() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        mCategory = new Category(driver);
        mCategory.getLogIN().click();
        mCategory.getEmail().sendKeys("most123@gmail.com");
        mCategory.getPassword().sendKeys("most1234");
        mCategory.getSubmit().click();
    }
    @When("user select random category")
    public void selectRandomCategory() throws InterruptedException {
        all = mCategory.getCategoryList().findElements(By.tagName("li"));
        int[] a = {0, 4, 8, 12, 13, 14, 15};
        Random rand = new Random();
        randomNum = rand.nextInt((5 - 0) + 1);
        index = a[randomNum];
        Actions action = new Actions(driver);
        action.moveToElement(all.get(index)).perform();
    }
    @And("sub-category if found")
    public void selectSubCategory() {
        if (index == 0 || index == 4 || index == 8) {
            all.get(index + 1).click();
        } else
            all.get(index).click();
    }

    @Then("list of products appear related to category")
    public void listOfProductAppear() throws InterruptedException {
        String status = "fail";
        try {
            WebElement parentElement = mCategory.getProductList();
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
