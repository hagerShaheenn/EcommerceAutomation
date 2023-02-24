package org.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPassword {

    WebDriver driver;
    public ResetPassword(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    private WebElement LogIN;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[3]/span/a")
    private WebElement resetPassword;
    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(name = "send-email")
    private WebElement recover;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    private WebElement message;


    public WebElement getLogIN() {
        return LogIN;
    }

    public WebElement getResetPassword() {
        return resetPassword;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getRecover() {
        return recover;
    }

    public WebElement getMessage() {
        return message;
    }
}
