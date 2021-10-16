import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;
//TC-002-A 	Verify header text “Welcome to 99 Bottles of Beer”
//        Test Data:
//        Browser: Chrome Browser 94.0
//        URL http://www.99-bottles-of-beer.net/
//        Expected Result: “Welcome to 99 Bottles of Beer ”
//        Steps:
//        Open Browser
//        Go to URL
//        Actual result = Get  header text
//        Assert  header text

public class Web2Test {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    @Test
    public void checkHeaderText() {
        driver.get("http://www.99-bottles-of-beer.net/");

        WebElement result = driver.findElement(By.xpath("//div[@id = 'main']/h2"));
        Assert.assertEquals(result.getText(), "Welcome to 99 Bottles of Beer");
    }

















}
