
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DemoNewUser{
    public static void main(String[] args) throws InterruptedException {
        String url = "https://login.mailchimp.com/";
        String chromeDriverPath = "C:\\software\\selenium\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get(url);
        Thread.sleep(100);

        String signUpUrl="https://login.mailchimp.com/signup/";
        driver.get(signUpUrl);

       // WebElement eleAddComputerButton = driver.findElement(By.xpath(locator_addcomputerbutton)); //finding that button
       // eleAddComputerButton.click();  //perform clicking
        //Thread.sleep(2000);

        String businessEmail = "//input[@id='email']";         //xpath
        String newUserName = "//input[@id='new_username']";
        String newPassword = "//input[@id='new_password']";
        //String checkBox = "//input[@name='marketing_newsletter']";
        String signUpButton = "//button[@id='create-account-enabled']";

        //Thread.sleep(2000);

        WebElement eleBusinessEmail = driver.findElement(By.xpath(businessEmail));
        WebElement eleNewUserName = driver.findElement(By.xpath(newUserName));
        WebElement eleNewPassword = driver.findElement(By.xpath(newPassword));
       // WebElement eleCheckBox = driver.findElement(By.cssSelector(checkBox));
        WebElement eleSignUpButton=driver.findElement(By.xpath(signUpButton));
       // new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='module-tabs-tab']//a[tex"))).click();


        eleBusinessEmail.sendKeys("greshmasrikandapu@gmail.com");     //giving input according to textbox
        eleNewUserName.sendKeys("");
        eleNewPassword.sendKeys("Re@1234567");
       // eleCheckBox.click();
        eleSignUpButton.click();
        //clicking the button to submit
        Thread.sleep(2000);
        driver.quit();
        System.out.println("successfully created new account");


    }
}