package stepDefinition;

import io.cucumber.java.After;
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
import org.page_object.ResetPassword;

import java.util.concurrent.TimeUnit;

public class ResetStepDefinition {
    WebDriver driver1;
    ResetPassword mResetPassword;

    @Given("user navigate to login  page")
    public void goToLoginPage() {

        WebDriverManager.chromedriver().setup();
        driver1 = new ChromeDriver();
        driver1.get("https://demo.nopcommerce.com/");
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mResetPassword = new ResetPassword(driver1);
        mResetPassword.getLogIN().click();
    }

    @When("user click Forgot password?")
    public void clickForgetPass() throws InterruptedException {

        mResetPassword.getResetPassword().click();

    }

    @Then("user write his email")
    public void writeEmail() {

        mResetPassword.getEmail().sendKeys("most123@gmail.com");
    }


    @And("user click on RECOVER")
    public void clickRecover() throws InterruptedException {

        mResetPassword.getRecover().click();
        Thread.sleep(3000);
    }

    @Then("message of instruction send to email")
    public void showMessage() {
        String status = "";
        try {
            if (mResetPassword.getMessage().getText().equals("Email with instructions has been sent to you."))
                status = "pass";
            else
                status = "fail";

        } catch (Exception e) {

        }
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
