package pkg2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver=null;

    public HomePage(WebDriver driver ) {
        this.driver = driver;
    }
    public void setSearchText(String value){
        String Loc="//input[@id='user-name']";
        WebElement ele=this.driver.findElement(By.xpath(Loc));
        ele.sendKeys(value);
    }
    public void setSearchValue(String value){
        String Loc="//input[@id='password']";
        WebElement ele=this.driver.findElement(By.xpath(Loc));
        ele.sendKeys(value);
    }
    public void clickSearchButton(){
        String Loc="//input[@id='login-button']";
        WebElement ele=this.driver.findElement(By.xpath(Loc));
        ele.click();
    }
}

