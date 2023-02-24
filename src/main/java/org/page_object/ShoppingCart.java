package org.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {


    WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    private WebElement LogIN;
    @FindBy(id = "Email")
    private WebElement email;
    @FindBy(id = "Password")
    private WebElement password;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
    private WebElement submit;
    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]")
    private WebElement categoryList;
    @FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody")
    private WebElement cartList;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")
    private WebElement book1;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]")
    private WebElement jewel1;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")
    private WebElement phone1;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[5]/a")
    private WebElement bookCategory;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[6]/a")
    private WebElement jewelCategory;

    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
    private WebElement shoppingCartButton;

    public WebElement getLogIN() {
        return LogIN;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getCategoryList() {
        return categoryList;
    }

    public WebElement getCartList() {
        return cartList;
    }

    public WebElement getBook1() {
        return book1;
    }


    public WebElement getJewel1() {
        return jewel1;
    }


    public WebElement getPhone1() {
        return phone1;
    }

    public WebElement getBookCategory() {
        return bookCategory;
    }

    public WebElement getJewelCategory() {
        return jewelCategory;
    }

    public WebElement getShoppingCartButton() {
        return shoppingCartButton;
    }
}
