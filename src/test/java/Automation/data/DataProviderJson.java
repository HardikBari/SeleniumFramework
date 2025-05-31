package Automation.data;

import TestComponents.comp.BaseTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DataProviderJson extends BaseTest {

    @DataProvider(name = "jsonData")

    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data= getjsondata();
        Object[][] result = new Object[data.size()][1];

        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i);  // pass entire HashMap as one object
        }

        return result;

    }
}
