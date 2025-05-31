package automationproject.pageobjects;

import automationproject.absractcomponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCataloug extends AbstractComponent {
    WebDriver driver;
    @FindBy(css = ".mb-3")
    List<WebElement> products;

    By productsBy = By.cssSelector(".mb-3");//we are using this to wait for the element to appear because waitForElementToAppear(productsBy); this method accept By elements only
    By cart = By.cssSelector(".card-body button:last-of-type");
    By toast = By.cssSelector("#toast-container");

    public ProductCataloug(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProducts() {
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getproductbyname(String prodaname) {

        WebElement prod = getProducts().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prodaname)).findFirst().orElse(null);
        return prod;

    }

    public void addToCart(String prodaname) throws InterruptedException {

        WebElement prod = getproductbyname(prodaname);
        prod.findElement(cart).click();
        waitForElementToAppear(toast);
        waitForElementToDisappear(By.cssSelector(".ng-animating"));


    }

}

