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
import org.page_object.Filter;
import org.page_object.Tag;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TagStepDefinition {
    int randomNum;
    WebDriver driver;
    Tag mTag;
    List<WebElement> all;

    @Given("user  logged in successfuly")
    public void loginSuccessfuly() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        mTag = new Tag(driver);
        mTag.getLogIN().click();
        mTag.getEmail().sendKeys("most123@gmail.com");
        mTag.getPassword().sendKeys("most1234");
        mTag.getSubmit().click();
    }
    @When("user select books category")
    public void selectShoes() throws InterruptedException {
        all = mTag.getCategoryList().findElements(By.tagName("li"));
        Actions action = new Actions(driver);
        action.moveToElement(all.get(14)).perform();
        all.get(14).click();
    }
    @And("user select apparel tag")
    public void selectApparel() throws InterruptedException {
        mTag.getAppreal().click();
    }
    @And("user select awesome tag")
    public void selectAwesome() throws InterruptedException {
        mTag.getAweome().click();
    }
    @And("user select book tag")
    public void selectBook() throws InterruptedException {
        mTag.getBook().click();
    }
    @Then("list  of products appear related to tag")
    public void listOfProducttAppear() throws InterruptedException {
        String status = "fail";


        try {
            WebElement parentElement = mTag.getProductList();
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
