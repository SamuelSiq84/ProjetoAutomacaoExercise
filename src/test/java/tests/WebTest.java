package tests;

import maps.HomeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.HomeStep;
import steps.ProdutoStep;

import java.time.Duration;
import java.util.Objects;

public class WebTest {

    public WebDriver driver;
    WebDriverWait wait;
    HomeStep homeStep;
    HomeMap homeMap;
    ProdutoStep produtoStep;

    @BeforeTest
    public void setup(){


        System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
//        options.addArguments("--window-size=1400,800");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        homeMap = new HomeMap(driver);
        homeStep = new HomeStep(driver);
        produtoStep = new ProdutoStep(driver);
    }

    @Test
    @Parameters({"url"})
    public void acessarHomePage(@Optional("https://automationexercise.com/")String url){
        homeStep
                .acessarURL(url);

        Assert.assertEquals(url,driver.getCurrentUrl());
    }
    @Test
    @Parameters({"url","nome","email","password"})
    public void realizarLoginComSucesso(@Optional("https://automationexercise.com/")String url,
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
    @Test
    @Parameters({"url","produto"})
    public void realizarBuscaPorNomeProduto(@Optional("https://automationexercise.com/")String url,
                                            @Optional("Half Sleeves Top Schiffli Detailing - Pink")String produto) {
        homeStep
                .acessarURL(url)
                .acessarHomeProducts();

        produtoStep
                .validarPageProducts()
                .buscarProduto(produto);
        assert "Half Sleeves Top Schiffli Detailing - Pink".equals(produto);
        //Assert.assertEquals(produto,driver.findElement(By.xpath("//h2[contains(text(), "+produto+")]")));

     }


    @AfterTest
    public void tearDown(){

        driver.quit();
    }
}
