package TestComponents.comp;

import automationproject.pageobjects.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
   public WebDriver driver;
   public LandingPage landingPage;
    //public String prodname = "zara coat 3";
  // public String country = "India";

    public WebDriver InitializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
<<<<<<< HEAD
        driver.manage().window().maximize();
=======
       //comment
        driver.manage().window().maximize();// Initialize the WebDriver here
>>>>>>> 776e9353eae011a35f4f3816966a1a536b1c6698
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public List<HashMap<String, String>> getjsondata() throws IOException {

        String jsoncontent=FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//java//Automation//data//UserData.json"), "UTF-8");
        System.out.println(jsoncontent);
        ObjectMapper mapper= new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {});
        return data;

    }

    public static String getScreenshot(WebDriver driver, String TestCaseName) throws IOException {

        TakesScreenshot ts= (TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File file= new File("/reports/" + TestCaseName + ".png");
        FileUtils.copyFile(source, file);
        return "/reports/" + TestCaseName + ".png";

    }
     @BeforeMethod
    public LandingPage LaunchApplication(){
        InitializeDriver();
         landingPage = new LandingPage(driver);
        landingPage.GoTo();
        return landingPage;
    }
    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    protected WebDriver driver() {

        return driver;
    }
}
