package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.page_object.Register;

import java.util.concurrent.TimeUnit;

public class RegisterStepDefinition {
    WebDriver driver1;
    Register mRegister;

    @Given("user navigate to register page")
    public void goToHomePage() {

        WebDriverManager.chromedriver().setup();
        driver1 = new ChromeDriver();
        driver1.get("https://demo.nopcommerce.com/");
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mRegister = new Register(driver1);
    }

    @Then("user click on register button from home page")
    public void clickRegisterButton() {
        mRegister.registerHomePage().click();

    }

    @When("user enter valid data")
    public void enterValidData() throws InterruptedException {
        mRegister.selectMale().click();
        mRegister.firstName().sendKeys("Mostafa");
        mRegister.getLastName().sendKeys("Mohamed");
        Select day = new Select(mRegister.selectDay());
        day.selectByValue("13");
        Select month = new Select(mRegister.selectMonth());
        month.selectByValue("5");
        Select year = new Select(mRegister.selectYear());
        year.selectByValue("2000");
        mRegister.getEmail().sendKeys("most123@gmail.com");
        mRegister.getCompany().sendKeys("FWD");
        mRegister.getNewsletter().click();
        mRegister.getPassword().sendKeys("most1234");
        mRegister.getConfirmPassword().sendKeys("most1234");


    }

    @And("user click on register button")
    public void clickRegister() throws InterruptedException {
        mRegister.getRegisterButton().click();

    }

    @Then("user registered successfully")
    public void loggedToHomePage() throws InterruptedException {
        String status = "";
        try {
            if (mRegister.getMessage().getText().equals("Your registration completed"))
                status = "pass";
            else
                status = "fail";
        } catch (Exception e) {

        }
        //System.out.println(status + mRegister.getMessage().getText().equals("Your registration completed"));
        Assert.assertEquals("pass", status);

    }

    @After
    public void clouser() {
        try {
            driver1.quit();
        } catch (Exception e) {
        }

    }

}
