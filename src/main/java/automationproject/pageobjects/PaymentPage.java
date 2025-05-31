package automationproject.pageobjects;

import automationproject.absractcomponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends AbstractComponent {
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement SelectCountry;
     @FindBy (xpath ="(//button[contains(@class,'ta-item')])[2]")
    WebElement SelectedCountry;
     @FindBy (css = ".action__submit")
    WebElement PlaceOrderButton;
     @FindBy (css = ".hero-primary")
    WebElement ConfirmMessage;
    By waitt = By.cssSelector(".ta-results");

    public String setPlaceOrderButton(String country) {
        Actions a = new Actions(driver);
        a.sendKeys(SelectCountry, country).build().perform();
        waitForElementToAppear(waitt);
        SelectedCountry.click();
        PlaceOrderButton.click();
        String textconfirm =ConfirmMessage.getText();
        return textconfirm;

    }

}
