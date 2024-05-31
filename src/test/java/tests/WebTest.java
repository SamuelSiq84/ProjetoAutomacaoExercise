package tests;

import maps.HomeMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.HomeStep;

import java.time.Duration;

public class WebTest {

    public WebDriver driver;
    WebDriverWait wait;
    HomeStep homeStep;
    HomeMap homeMap;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        homeMap = new HomeMap(driver);
        homeStep = new HomeStep(driver);
    }

    @Test
    @Parameters({"url"})
    public void acessarHomePageURL(@Optional("https://automationexercise.com/")String url){
        homeStep
                .acessarURL(url);
    }
}
