package steps;

import commons.ManipularElementosWeb;
import maps.ProdutoMap;
import org.openqa.selenium.WebDriver;

public class ProdutoStep extends ProdutoMap {
    public ProdutoStep(WebDriver driver) {
        super(driver);
    }
    ManipularElementosWeb resolvers = new ManipularElementosWeb(driver);

    public ProdutoStep fecharIframeAd(){
        resolvers.iframeAd();
        fecharAd.click();

        return this;
    }
}
