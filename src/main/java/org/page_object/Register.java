package org.page_object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register {

    WebDriver driver;

    public Register(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    private WebElement register;
    @FindBy(xpath = "//*[@id=\"gender-male\"]")
    private WebElement male;

    @FindBy(id = "FirstName")
    private WebElement firstName;
    @FindBy(id = "LastName")
    private WebElement lastName;
    @FindBy(name = "DateOfBirthDay")
    private WebElement selectDay;
    @FindBy(name = "DateOfBirthMonth")
    private WebElement selectMonth;
    @FindBy(name = "DateOfBirthYear")
    private WebElement selectYear;
    @FindBy(id = "Email")
    private WebElement email;
    @FindBy(id = "Company")
    private WebElement company;
    @FindBy(id = "Newsletter")
    private WebElement newsletter;
    @FindBy(id = "Password")
    private WebElement password;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;
    @FindBy(id = "register-button")
    private WebElement registerButton;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")
    private WebElement message;



    public WebElement selectDay() {
        return selectDay;
    }
    public WebElement selectMonth() {
        return selectMonth;
    }
    public WebElement registerHomePage() {
        return register;
    }
    public WebElement selectMale() {
        return male;
    }

    public WebElement firstName() {
        return firstName;
    }

    public WebElement selectYear() {
        return selectYear;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getNewsletter() {
        return newsletter;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getLastName() {
        return lastName;
    }
}
