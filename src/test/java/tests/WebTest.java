package tests;

import maps.HomeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
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

        Assert.assertEquals(url,driver.getCurrentUrl());
    }
    @Test
    @Parameters({"url","nome","email","password"})
    public void realizarLogin(@Optional("https://automationexercise.com/")String url,
                              @Optional("Samuel") String nome,
                              @Optional("samuel.siqueira.pereira@gmail.com")String email,
                              @Optional("123456")String password){
        homeStep
                .acessarURL(url)
                .acessarLoginPage()
                .loginHome(email,password)
                .validarLogin(nome);
        Assert.assertEquals(url,driver.getCurrentUrl());

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
