package automationproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

public class OrdersPage {

    WebDriver driver;
    public OrdersPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@routerlink='/dashboard/myorders']")
    public WebElement myOrdersButton;


    @FindBy(css="tbody tr td:nth-child(3)")
    public List<WebElement> orderName;

    public void ClickMyOrdersButton() {
        myOrdersButton.click();
    }

    public Boolean getPorudtName() {
        //String itemname= orderName.get(0).getText();
       // System.out.println(itemname);
        Boolean orderpresent = orderName.stream().anyMatch(product->product.getText().equalsIgnoreCase("ZARA COAT 3"));
        return orderpresent;
    }


}
