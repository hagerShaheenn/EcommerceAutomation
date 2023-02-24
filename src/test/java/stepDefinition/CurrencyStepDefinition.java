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
import org.openqa.selenium.support.ui.Select;
import org.page_object.Currency;
import org.page_object.Search;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CurrencyStepDefinition {

    WebDriver driver;
    Currency mCurrency;

    @Given("user logged in succesfuly")
    public void loginSuccessfuly() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        mCurrency = new Currency(driver);
        mCurrency.getLogIN().click();
        mCurrency.getEmail().sendKeys("most123@gmail.com");
        mCurrency.getPassword().sendKeys("most1234");
        mCurrency.getSubmit().click();
    }

    @When("user click on currency list and select Euro")
    public void clickOnCurrencyListAndSelectEuro() {


        Select year = new Select(mCurrency.getCurrencyList());

        year.selectByVisibleText("Euro");
    }


    @Then("Euro appear on the currency field")
    public void EuroCurrencyAppear() {

        Select option = new Select(mCurrency.getCurrencyList());


        String status = "fail";
        try {

            if (option.getFirstSelectedOption().getText().equals("Euro"))
                status = "pass";
        } catch (Exception e) {
        }
        Assert.assertEquals("pass", status);

    }




    @When("user click on currency field and select US Dollar")
    public void clickOnCurrencyListAndSelectUSDollar() {
        Select year = new Select(mCurrency.getCurrencyList());

        year.selectByVisibleText("US Dollar");

    }


    @Then("US Dollar appear on the currency field")
    public void USDollarCurrencyAppear() {

        Select option = new Select(mCurrency.getCurrencyList());


        String status = "fail";
        try {

            if (option.getFirstSelectedOption().getText().equals("US Dollar"))
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
