import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Demojson {
    WebDriver driver = null;

    @DataProvider(name = "data-set")
    public static Object[][] DataSet() {
        Object[][] obj = {
                {"valid","standard_user", "secret_sauce"},
                {"Invalid","locked_out_user", "secret_sauce"},
                {"valid","problem_user", "secret_sauce"},
                {"valid","performance_glitch_user", "secret_sauce"},
                {"Invalid", "Problem_out_user", "asdgsggdja"}
        };
        return obj;
    }

    @BeforeMethod
    public void setUp() throws IOException, ParseException {
        //System.out.println("\n\n \t Iam inside setUp method");
        //String url = "https://www.saucedemo.com/";
        String chromeDriverPath = "C:\\software\\selenium\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        String UrlDataPath = "src/main/resources/UrlFile.json";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        FileReader fr = new FileReader(UrlDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        String url = (String) jsonObject.get("url");
        System.out.println(url);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test(dataProvider = "data-set")
    public void search(String type,String username, String password) throws IOException, ParseException {
        System.out.println("username= " + username + " " + "password=" + password);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        //WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(3));
        String LoginDataPath = "src/main/resources/LoginData.json";
        FileReader fr = new FileReader(LoginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONArray jsonarray = (JSONArray) obj;

        //Iterate over employee array
        jsonarray.forEach(tc1 -> parseEmployeeObject((JSONObject) tc1));

//        if (type.equals("valid")) {
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='title']")));
//        } else
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='error']")));
    }
        private static void parseEmployeeObject (JSONObject tc)
        {
            //Get employee object within list
            JSONObject Object = (JSONObject) tc.get("tc");

            //Get employee first name
            String firstName = (String) Object.get("username");
            System.out.println(firstName);

            //Get employee last name
            String password1 = (String) Object.get("password");
            System.out.println(password1);

            //Get employee website name
            String website = (String) Object.get("type");
            System.out.println(website);
        }
}

