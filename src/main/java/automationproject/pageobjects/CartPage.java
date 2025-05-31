package automationproject.pageobjects;

import automationproject.absractcomponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }

    @FindBy(css = ".cartSection h3")
    List<WebElement> items;
    @FindBy(css = ".totalRow button")
    WebElement checkoutButton;

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartButton;

    public void setCartButton() {

        cartButton.click();
    }

    public boolean match(String prodname) {
        boolean match = items.stream().anyMatch(item -> item.getText().equalsIgnoreCase(prodname));
        return match;
    }

    public void setCheckoutButton() {
        checkoutButton.click();
    }
}
