package AutomationProejcts.Tests;

import Automation.data.DataProviderJson;
import TestComponents.comp.BaseTest;
import automationproject.pageobjects.CartPage;
import automationproject.pageobjects.OrdersPage;
import automationproject.pageobjects.PaymentPage;
import automationproject.pageobjects.ProductCataloug;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class StandAlone extends BaseTest {

    @Test (dataProvider = "jsonData", dataProviderClass = DataProviderJson.class,groups = "make order")

    public void standaloneTest(HashMap<String,String> input) throws InterruptedException {

        landingPage.login(input.get("email"), input.get("password"));
        ProductCataloug productCataloug = new ProductCataloug(driver);
        productCataloug.addToCart(input.get("product"));
        CartPage cartPage = new CartPage(driver);
        cartPage.setCartButton();
        boolean value = cartPage.match(input.get("product"));
        Assert.assertTrue(value);
        cartPage.setCheckoutButton();
        System.out.println(value);

        PaymentPage paymentPage = new PaymentPage(driver);
        String text = paymentPage.setPlaceOrderButton(input.get("country"));

        Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        System.out.println(text);
    }

    @Test(dependsOnMethods = {"standaloneTest"},dataProvider = "jsonData", dataProviderClass = DataProviderJson.class)
    public void CheckOrders(HashMap<String,String> input) {

        landingPage.login(input.get("email"), input.get("password"));
        OrdersPage ordersPage = new OrdersPage(driver);
        ordersPage.ClickMyOrdersButton();
        Boolean match = ordersPage.getPorudtName(input.get("product"));
        Assert.assertTrue(match);
        System.out.println(match);

    }



//    @DataProvider
//
//    public Object[][] getData() throws IOException {
//       List<HashMap<String,String>> data= getjsondata();
//       return new Object[][] {
//                {data.get(0)},
//       };

//    }
}