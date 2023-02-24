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
import org.page_object.Login;
import org.page_object.Search;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchStepDefinition {

    WebDriver driver;
    Search mSearch;

    @Given("user logged in successfuly")
    public void loginSuccessfuly() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        mSearch = new Search(driver);
        mSearch.getLogIN().click();
        mSearch.getEmail().sendKeys("most123@gmail.com");
        mSearch.getPassword().sendKeys("most1234");
      mSearch.getSubmit().click();
    }

    @When("user enter product in the search field")
    public void enterDatainSearchfield() {

        mSearch.getSearchField().sendKeys("book");

    }

    @And("click on search button")
    public void clickSearch() {
        mSearch.getSearchButton().click();
    }


    @Then("list of product appear related to search product")
    public void listOfUserAppear() {

        String status = "fail";
        try {
            WebElement parentElement = mSearch.getSearchList();
            List<WebElement> allChildElements = parentElement.findElements(By.xpath("*"));
            int size = allChildElements.size();
            System.out.println(size);
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
