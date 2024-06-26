package commons;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import configuraDriveWeb.BasePage;
import maps.ProdutoMap;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ManipularElementosWeb extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ManipularElementosWeb.class);

    public ManipularElementosWeb(WebDriver driver) {
        super(driver);
    }
    ProdutoMap produtoMap = new ProdutoMap(driver);

    @FindBy(id = "dismiss-button")
    public WebElement fecharAd;

    @FindBy(xpath = "//div[contains(@class, 'ns-9ox5o-e-14 button-common close-button milo-animation delay-4')]")
    public WebElement fecharAd2;

    public ManipularElementosWeb iframeAd(){

    WebElement iframeElement = driver.findElement(By.id("aswift_6"));
//    WebElement iframeElement2 = driver.findElement(By.id("google_esf"));
//    if (iframeElement2 >){
//        System.out.println("passou pelo primeiro Iframe");
//        driver.switchTo().frame(iframeElement);
//        fecharAd.click();
//
//    }else {
//        driver.switchTo().frame(iframeElement2);
//        System.out.println("passou pelo segundo Iframe");
//        fecharAd2.click();
//    }
        if (iframeElement != driver.findElement(By.id("google_esf"))) {
            System.out.println("passou pelo primeiro Iframe");
            driver.switchTo().frame(iframeElement);
            fecharAd.click();
        }else {
            fecharAd2.click();
        }
        //        driver.switchTo().frame(driver.findElement(By.id("aswift_6")));

        return this;
    }
    public ManipularElementosWeb scrollDownPageProdutos(){
        JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;
        jsExecuter.executeScript("window.scrollTo(0,500)");
        return this;
    }



}

