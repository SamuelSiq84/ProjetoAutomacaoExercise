package maps;

import configuraDriveWeb.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomeMap extends BasePage {
    public HomeMap(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), ' Signup / Login')]")
    public WebElement btnLogin;

    @FindBy(name = "email")
    public WebElement campoEmail;

    @FindBy(name = "password")
    public WebElement campoPassword;

}
