package org.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tag {


    WebDriver driver;
    public Tag(WebDriver driver) {
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
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div")
    private WebElement productList;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div[3]/div[2]/div[1]/ul/li[1]/a")
    private WebElement appreal;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div[3]/div[2]/div[1]/ul/li[2]/a")
    private WebElement aweome;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div[3]/div[2]/div[1]/ul/li[3]/a")
    private WebElement book;
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
    public WebElement getProductList() {
        return productList;
    }

    public WebElement getAppreal() {
        return appreal;
    }

    public WebElement getAweome() {
        return aweome;
    }

    public WebElement getBook() {
        return book;
    }
}
