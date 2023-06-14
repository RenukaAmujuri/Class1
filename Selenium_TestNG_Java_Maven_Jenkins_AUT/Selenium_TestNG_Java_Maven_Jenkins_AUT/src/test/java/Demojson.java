import pkg2.HomePage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Demojson {
    WebDriver driver = null;

    @BeforeMethod
    public void setUp() throws IOException, ParseException {
        String ChromeDriverPath="C:\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
        String loginDataPath="src/main/resources/UrlFile.json";
        driver= new ChromeDriver();
        System.getProperty("webdriver.chrome.driver",ChromeDriverPath);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        System.out.println(driver.getTitle());
        FileReader fr =new FileReader(loginDataPath);
        JSONParser parser=new JSONParser();
        Object obj =parser.parse(fr);
        JSONObject jsonObject=(JSONObject)obj;
        String url = (String)jsonObject.get("url");
        System.out.println(url);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void search() throws IOException, ParseException, InterruptedException {

        String LoginDataPath = "src/main/resources/LoginData.json";
        FileReader fr = new FileReader(LoginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc01");
        String searchText = (String) tc.get("username");
        String searchValue = (String) tc.get("password");
        System.out.println(searchText);
        //String searchtext="ace";
        //String expectedmessage="Computers found";
        HomePage hp = new HomePage(driver);
        hp.setSearchText(searchText);
        hp.setSearchValue(searchValue);
        hp.clickSearchButton();
        Thread.sleep(1000);
    }
    @Test
    public void search1() throws IOException, ParseException, InterruptedException {

        String LoginDataPath = "src/main/resources/LoginData.json";
        FileReader fr = new FileReader(LoginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc02");
        String searchText = (String) tc.get("username");
        String searchValue = (String) tc.get("password");
        System.out.println(searchText);
        HomePage hp = new HomePage(driver);
        hp.setSearchText(searchText);
        hp.setSearchValue(searchValue);
        hp.clickSearchButton();
        Thread.sleep(1000);
    }
    @Test
    public void searchTestcase3() throws IOException, ParseException, InterruptedException {

        String LoginDataPath = "src/main/resources/LoginData.json";
        FileReader fr = new FileReader(LoginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc03");
        String searchText = (String) tc.get("username");
        String searchValue = (String) tc.get("password");
        System.out.println(searchText);
        //String searchtext="ace";
        //String expectedmessage="Computers found";
        HomePage hp = new HomePage(driver);
        hp.setSearchText(searchText);
        hp.setSearchValue(searchValue);
        hp.clickSearchButton();
        Thread.sleep(1000);
    }
    @Test
    public void searchTestcase4() throws IOException, ParseException, InterruptedException {

        String LoginDataPath = "src/main/resources/LoginData.json";
        FileReader fr = new FileReader(LoginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc04");
        String searchText = (String) tc.get("username");
        String searchValue = (String) tc.get("password");
        System.out.println(searchText);
        //String searchtext="ace";
        //String expectedmessage="Computers found";
        HomePage hp = new HomePage(driver);
        hp.setSearchText(searchText);
        hp.setSearchValue(searchValue);
        hp.clickSearchButton();
        Thread.sleep(1000);
    }
    @Test
    public void searchTestcase5() throws IOException, ParseException, InterruptedException {

        String LoginDataPath = "src/main/resources/LoginData.json";
        FileReader fr = new FileReader(LoginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc05");
        String searchText = (String) tc.get("username");
        String searchValue = (String) tc.get("password");
        System.out.println(searchText);
        HomePage hp = new HomePage(driver);
        hp.setSearchText(searchText);
        hp.setSearchValue(searchValue);
        hp.clickSearchButton();
        Thread.sleep(1000);
    }
}