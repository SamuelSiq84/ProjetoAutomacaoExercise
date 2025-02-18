package steps;


import commons.ManipularElementosWeb;
import maps.ProdutoMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProdutoStep extends ProdutoMap {
    public ProdutoStep(WebDriver driver) {
        super(driver);
    }
    ManipularElementosWeb resolvers = new ManipularElementosWeb(driver);

    public ProdutoStep fecharIframeAd(){
        resolvers.iframeAd();
//        fecharAd.click();

        return this;
    }
    public ProdutoStep validarPageProducts(){
        driver.findElement(By.xpath("//h2[contains(text(), 'All Products')]"));
        return this;
    }
    public ProdutoStep buscarProduto(String produto){
        campoBuscarProduto.sendKeys(produto);
        btnBuscarProduto.click();
        resolvers.scrollDownPageProdutos();
        btnViewDetailsProduct.click();



        return this;
    }
}
