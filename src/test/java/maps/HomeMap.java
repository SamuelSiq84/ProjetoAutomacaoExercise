package maps;

import configuraDriveWeb.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;


public class HomeMap extends BasePage {
    public HomeMap(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), ' Signup / Login')]")
    public WebElement btnLoginHome;

    @FindBy(name = "email")
    public WebElement campoEmail;

    @FindBy(name = "password")
    public WebElement campoPassword;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    public WebElement btnSubmit;

    @FindBy(xpath = "//p[contains(text(), 'Your email or password is incorrect!')]")
    public WebElement lblinvalidoEmail;

    @FindBy(xpath = "//a[contains(., ' Logout')]")
    public WebElement lblLogoutHome;

    @FindBy(xpath = "//a[contains(text(), ' Products')]")
    public WebElement btnProducts;




}
