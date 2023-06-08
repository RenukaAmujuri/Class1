package pkg2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void userName(String value)          //sending some text
    {
        String loc = "//input[@id='user-name']";
        WebElement ele = this.driver.findElement(By.xpath(loc));
        ele.sendKeys(value);
    }

    public void setPassword(String value)          //sending some text
    {
        String loc = "//input[@id='password']";
        WebElement ele = this.driver.findElement(By.xpath(loc));
        ele.sendKeys(value);
    }

    public void clickLoginButton()                 //after that click the button
    {
        String loc = "//input[@id='login-button']";
        WebElement ele = this.driver.findElement(By.xpath(loc));
        ele.click();
    }

}
