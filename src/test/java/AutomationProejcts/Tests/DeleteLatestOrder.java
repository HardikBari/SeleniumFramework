package AutomationProejcts.Tests;

import Automation.data.DataProviderJson;
import TestComponents.comp.BaseTest;
import automationproject.pageobjects.OrdersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;


public class DeleteLatestOrder extends BaseTest {

    @Test(dependsOnGroups = "make order",dataProvider = "jsonData",dataProviderClass = DataProviderJson.class)
    public void deletelatestorder(HashMap<String,String> input) {
        landingPage.login(input.get("email"), input.get("password"));
        OrdersPage orderpage=new OrdersPage(driver);
        orderpage.ClickMyOrdersButton();
        orderpage.ClickDeleteButton();
        String match=orderpage.getOrderDeletedMessage();
        Assert.assertEquals(match, "Orders Deleted Successfully");

    }
}
