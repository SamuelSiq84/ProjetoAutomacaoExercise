package commons;

import configuraDriveWeb.BasePage;
import maps.ProdutoMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManipularElementosWeb extends BasePage {
    public ManipularElementosWeb(WebDriver driver) {
        super(driver);
    }
    ProdutoMap produtoMap = new ProdutoMap(driver);

    public ManipularElementosWeb iframeAd(){
        driver.switchTo().frame(driver.findElement(By.id("aswift_8")));
//        if (wait.until(ExpectedConditions.vi))
        return this;
    }


}

