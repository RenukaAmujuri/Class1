import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pkg2.HomePage;
import pkg2.HomePageSoft;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

public class TestcaseSearchComputerJson {
    WebDriver driver=null;
    @BeforeMethod
    public void setUp() throws IOException, ParseException {
        String ChromeDriverPath = "C:\\software\\selenium\\chromedriver\\chromedriver.exe";
        String loginDataPath="src/main/resources/LoginDta.json";
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", ChromeDriverPath);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        FileReader fr =new FileReader(loginDataPath);
        JSONParser parser=new JSONParser();
        Object obj =parser.parse(fr);
        JSONObject jsonObject=(JSONObject)obj;
        String url = (String)jsonObject.get("url");
        driver.get(url);

    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void searchComputerUsingAlphabet() throws InterruptedException, IOException, ParseException {
// try {
        String searchComputerDataPath = "src/main/resources/SearchComputerData.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc01");
        String searchText = (String) tc.get("searchText");
        System.out.println(searchText);
        String searchtext = "ace";
        String expectedmessage = "Computers found";
        HomePageSoft hp = new HomePageSoft(driver);
        hp.setSearchText(searchtext);
        hp.clickSearchButton();
        Thread.sleep(5000);
        String actualMessage = hp.getH1Heading();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actualMessage).contains(expectedmessage);
        String[] arrMessage = actualMessage.split(" ");
        int numberofComputers = parseInt(arrMessage[0]);
        softly.assertThat(numberofComputers).isGreaterThanOrEqualTo(1);
        softly.assertThat(numberofComputers).isGreaterThanOrEqualTo(100);
    }
    @Test
    public void searchComputerUsingNumber () throws InterruptedException, IOException, ParseException {
//try{
        String searchComputerDataPath = "src/main/resources/SearchComputerData.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("tc02");
        String setsearchText = (String) tc.get("searchText");
        System.out.println(setsearchText);
        String expectedMessage = "Computers found";
        HomePageSoft hp = new HomePageSoft(driver);
        hp.setSearchText(setsearchText);
        hp.clickSearchButton();
        Thread.sleep(5000);
        String actualMessage = hp.getH1Heading();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actualMessage).contains(expectedMessage);
        String[] arrMessage = actualMessage.split(" ");
        int numberOfComputers = parseInt(arrMessage[0]);
        softly.assertThat(numberOfComputers).isGreaterThanOrEqualTo(1);
        assertThat(numberOfComputers).isGreaterThanOrEqualTo(100);
// }



        }

    }


