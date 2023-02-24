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
import org.openqa.selenium.support.ui.Select;
import org.page_object.CreateOrder;
import org.page_object.WishList;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class CreateOrderStepDefinition {
    int randomNum;
    WebDriver driver;
    CreateOrder mCreateOrder;
    List<WebElement> all;
    int index;

    @Given("user   logged  in  successfuly")
    public void loginSuccessfuly() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        mCreateOrder = new CreateOrder(driver);
        mCreateOrder.getLogIN().click();
        mCreateOrder.getEmail().sendKeys("most123@gmail.com");
        mCreateOrder.getPassword().sendKeys("most1234");
        mCreateOrder.getSubmit().click();
    }

    @When("user select   books  category")
    public void selectCellPhoneSubCategory() throws InterruptedException {
        Thread.sleep(1000);
        mCreateOrder.getBookCategory().click();
    }

    @And("user add to cart")
    public void AddPhoneToCart() {
        mCreateOrder.getBook1().click();
    }

    @And("user click on shopping cart")
    public void selectBooksSubCategory() {
        mCreateOrder.getShoppingCartButton().click();
    }

    @And("user agree the terms and click on checkout")
    public void Add2BooksToCart() throws InterruptedException {
        mCreateOrder.getAgreeButton().click();
        mCreateOrder.getCheckoutButton().click();
    }

    @And("user  enter required data")
    public void selectJewelrySubCategory() {
        try{ if (mCreateOrder.getAddressfound().isDisplayed()) {
            mCreateOrder.getContinue1().click();
            mCreateOrder.getContinue2().click();
            mCreateOrder.getContinue3().click();
            mCreateOrder.getContinue4().click();
            mCreateOrder.getConfirm().click();
        } else {
            Select option = new Select(mCreateOrder.getSelectCountry());
            option.selectByVisibleText("Egypt");
            mCreateOrder.getCityField().sendKeys("Cairo");
            mCreateOrder.getAddrressField().sendKeys("15 st 2 Hdayek el zyton");
            mCreateOrder.getZipCodeField().sendKeys("32654");
            mCreateOrder.getPhoneNumberField().sendKeys("01748876543");
            mCreateOrder.getContinue1().click();
            mCreateOrder.getContinue2().click();
            mCreateOrder.getContinue3().click();
            mCreateOrder.getContinue4().click();
            mCreateOrder.getConfirm().click();
        }}catch (Exception e){
            Select option = new Select(mCreateOrder.getSelectCountry());
            option.selectByVisibleText("Egypt");
            mCreateOrder.getCityField().sendKeys("Cairo");
            mCreateOrder.getAddrressField().sendKeys("15 st 2 Hdayek el zyton");
            mCreateOrder.getZipCodeField().sendKeys("32654");
            mCreateOrder.getPhoneNumberField().sendKeys("01748876543");
            mCreateOrder.getContinue1().click();
            mCreateOrder.getContinue2().click();
            mCreateOrder.getContinue3().click();
            mCreateOrder.getContinue4().click();
            mCreateOrder.getConfirm().click();
        }

    }

    @Then("Message of Your order has been successfully processed! appear")
    public void listOfProductAppearInShoppingCart() throws InterruptedException {
        Thread.sleep(2000);
        String status = "fail";
        try {
            if (mCreateOrder.getConfirmText().getText().equals("Your order has been successfully processed!"))
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
