package AutomationProejcts.Tests;

import Automation.data.DataProviderJson;
import TestComponents.comp.BaseTest;
import TestComponents.comp.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginError extends BaseTest {

    @Test(priority = 1, dataProvider = "jsonData", dataProviderClass = DataProviderJson.class)

    public void WrongPasswordErrorTest(HashMap<String, String> input) {

        landingPage.login(input.get("email"), input.get("Wrongpassword"));
        String error1 = landingPage.getErrorMessage();
        Assert.assertTrue(error1.equalsIgnoreCase("Incorrect email or password."));
    }

    @Test(priority = 2,retryAnalyzer= Retry.class)
    public void BlankLoginError() {
        //landingPage.login("", ""
        landingPage.loginButton.click();

        String BlankErroE = landingPage.EmailmissingMsg();
        String BlankErroP = landingPage.PasswordMissingMsg();
        Assert.assertTrue(BlankErroE.equalsIgnoreCase("*Email is required"));
        Assert.assertTrue(BlankErroP.equalsIgnoreCase("*Password is required"));
    }

//    @DataProvider
//
//    public Object[][] getData() throws IOException {
//        List<HashMap<String, String>> data = getjsondata();
//        return new Object[][]{{data.get(0)},};
//    }
}