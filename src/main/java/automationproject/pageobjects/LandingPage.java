package automationproject.pageobjects;

import automationproject.absractcomponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;
   //public String email= "nanny@gmail.com";
   // public String password= "Nanny@123";
  //  public String Wrongpassword= "Nanny@1234";

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); //very important step without this webelement will not be initialized
    }

    @FindBy(id = "userEmail")
    WebElement emailField;
    @FindBy(id = "userPassword")
    WebElement passwordField;
    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy (css = "div.toast-error")
    public WebElement errorMessage;

   @FindBy (xpath="//div[contains(text(), '*Email is required')]")
   WebElement emailmissing;

   @FindBy (xpath = "//div[contains(text(), '*Password is required')]")
   WebElement passwordmissing;

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        waitForElementToAppear(errorMessage);
        String error = errorMessage.getText();
        System.out.println(error);
        return error;
    }

    public String EmailmissingMsg(){
        waitForElementToAppear(emailmissing);
        String emailerror = emailmissing.getText();
        System.out.println(emailerror);
        return emailerror;

    }

    public String PasswordMissingMsg(){
        waitForElementToAppear(passwordmissing);
        String Passworderror = passwordmissing.getText();
        System.out.println(Passworderror);
        return Passworderror;

    }

    public void GoTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }
}
