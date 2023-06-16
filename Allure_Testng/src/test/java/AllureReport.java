import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import java.util.concurrent.TimeUnit;

    public class AllureReport{

        WebDriver driver;

        @BeforeClass
        public void setUp() {
            String ChromeDriverPath="C:\\software\\selenium\\chromedriver\\chromedriver.exe";
            driver =new ChromeDriver();
            System.getProperty("webdriver.chrome.driver",ChromeDriverPath);
            driver.get("https://demo.nopcommerce.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            System.out.println(driver.getTitle());

        }
        @Test(priority = 1)
        public void logoPresence() throws InterruptedException
        {
            boolean dispStatus=driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
            Assert.assertEquals(dispStatus, true);
        }

        @Test(priority=2)
        public void loginTest() throws InterruptedException
        {
            driver.findElement(By.linkText("Log in")).click();
            driver.findElement(By.id("Email")).sendKeys("asr7780749210@gmail.com.com");
            driver.findElement(By.id("Password")).sendKeys("Test@123");
            driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
            Thread.sleep(3000);
            Assert.assertEquals(driver.getTitle(), "nopCommerce demo store123");

        }


        @Test(priority=3)
        public void registrationTest()
        {
            throw new SkipException("Skipping this Test");
        }

        @AfterClass
        public void tearDown()
        {
            driver.quit();
        }
    }

