import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Demo1 {
    WebDriver driver = null;

    @DataProvider(name = "data-set")
    public static Object[][] DataSet() {
        Object[][] obj = {
                {"valid","standard_user", "secret_sauce" },
                {"Invalid","Renuka", "1234" }
        };
        return obj;
    }
    @BeforeMethod
    public void setUp() {
        //System.out.println("\n\n \t Iam inside setUp method");
        String url = "https://www.saucedemo.com/";
        String chromeDriverPath = "C:\\software\\selenium\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
    @Test(dataProvider = "data-set")
    public void search(String type,String username, String password) throws InterruptedException {
        System.out.println("type=" + type +" "+"username= " + username + " " + "password=" + password);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        if (type.equals("valid")) {
            System.out.println("login successfully");
        }
        else
        {
            System.out.println("Invalid login");
        }

    }
    }
