package org.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrder {


    WebDriver driver;

    public CreateOrder(WebDriver driver) {
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

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[5]/a")
    private WebElement bookCategory;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")
    private WebElement book1;
    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
    private WebElement shoppingCartButton;
    @FindBy(xpath = "//*[@id=\"termsofservice\"]")
    private WebElement agreeButton;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    private WebElement checkoutButton;
    @FindBy(xpath = "//*[@id=\"BillingNewAddress_CountryId\"]")
    private WebElement selectCountry;
    @FindBy(xpath = "//*[@id=\"BillingNewAddress_City\"]")
    private WebElement cityField;
    @FindBy(xpath = "//*[@id=\"BillingNewAddress_Address1\"]")
    private WebElement addrressField;

    @FindBy(xpath = "//*[@id=\"BillingNewAddress_ZipPostalCode\"]")
    private WebElement zipCodeField;
    @FindBy(xpath = "//*[@id=\"BillingNewAddress_PhoneNumber\"]")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[4]")
    private WebElement continue1;
    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
    private WebElement continue2;
    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
    private WebElement continue3;
    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
    private WebElement continue4;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[2]/button")
    private WebElement confirm;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
    private WebElement confirmText;

    @FindBy(xpath = "//*[@id=\"checkout-billing-load\"]/div/div[2]/label")
    private WebElement addressfound;

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

    public WebElement getBook1() {
        return book1;
    }

    public WebElement getBookCategory() {
        return bookCategory;
    }

    public WebElement getShoppingCartButton() {
        return shoppingCartButton;
    }

    public WebElement getAgreeButton() {
        return agreeButton;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public WebElement getSelectCountry() {
        return selectCountry;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getAddrressField() {
        return addrressField;
    }

    public WebElement getAddressfound() {
        return addressfound;
    }

    public WebElement getZipCodeField() {
        return zipCodeField;
    }

    public WebElement getPhoneNumberField() {
        return phoneNumberField;
    }

    public WebElement getContinue1() {
        return continue1;
    }

    public WebElement getContinue2() {
        return continue2;
    }

    public WebElement getContinue3() {
        return continue3;
    }

    public WebElement getContinue4() {
        return continue4;
    }

    public WebElement getConfirm() {
        return confirm;
    }

    public WebElement getConfirmText() {
        return confirmText;
    }
}
