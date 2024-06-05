package maps;

import configuraDriveWeb.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoMap extends BasePage {
    public ProdutoMap(WebDriver driver) {
        super(driver);
    }
//    @FindBy(id = "ad_position_box")
//    public WebElement iframeAd;

    @FindBy(xpath = "//div[contains(@class, 'ns-gyvng-e-15')]")
    public WebElement fecharAd;
}
