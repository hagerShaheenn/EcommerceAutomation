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
import org.page_object.Category;
import org.page_object.Filter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class FilterStepDefinition {
    int randomNum;
    WebDriver driver;
    Filter mFilter;
    List<WebElement> all;
    int index;

    @Given("user logged  in successfuly")
    public void loginSuccessfuly() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        mFilter = new Filter(driver);
        mFilter.getLogIN().click();
        mFilter.getEmail().sendKeys("most123@gmail.com");
        mFilter.getPassword().sendKeys("most1234");
        mFilter.getSubmit().click();
    }
    @When("user select shoes from apparel category")
    public void selectShoes() throws InterruptedException {
        all = mFilter.getCategoryList().findElements(By.tagName("li"));
        Actions action = new Actions(driver);
        action.moveToElement(all.get(8)).perform();
        all.get(9).click();
    }
    @And("user select color from filter")
    public void selectColor() throws InterruptedException {
        mFilter.getColor().click();
    }
    @Then("list of products appear related to color")
    public void listOfProductAppear() throws InterruptedException {
        String status = "fail";
        try {
            WebElement parentElement = mFilter.getProductList();
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
