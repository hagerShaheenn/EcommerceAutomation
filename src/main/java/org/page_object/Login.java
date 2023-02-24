package org.page_object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;

    public Login(WebDriver driver) {
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

    @FindBy(className = "ico-logout")
    private WebElement logout;

    public WebElement getLogIN() {
        return LogIN;
    }


    public WebElement Email() {
        return email;
    }

    public WebElement Password() {
        return password;
    }

    public WebElement Submit() {
        return submit;
    }

    public WebElement logout() {
        return logout;
    }
}
