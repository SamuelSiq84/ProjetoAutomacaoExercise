package maps;

import configuraDriveWeb.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoMap extends BasePage {
    public ProdutoMap(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "search_product")
    public WebElement campoBuscarProduto;

    @FindBy(id = "submit_search")
    public WebElement btnBuscarProduto;

    @FindBy(xpath = "//i[contains(@class, 'fa fa-plus-square')]")
    public WebElement btnViewDetailsProduct;





}
