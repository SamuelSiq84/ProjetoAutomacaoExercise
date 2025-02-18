package steps;

import maps.HomeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomeStep extends HomeMap {
    public HomeStep(WebDriver driver) {
        super(driver);
    }
    HomeMap homeMap = new HomeMap(driver);

    public HomeStep acessarURL(String url){
    driver.get(url);
    return this;
    }
    public HomeStep acessarLoginPage(){
    btnLoginHome.click();
    return this;
    }
    public HomeStep loginHome(String email, String password){
    campoEmail.sendKeys(email);
    campoPassword.sendKeys(password);
    btnSubmit.click();
    return this;
    }
    public HomeStep validarLogin(String nome){
        driver.findElement(By.xpath("//b[contains(text(), '" + nome + "')]"));
        return this;
    }
    public HomeStep acessarHomeProducts(){
        btnProducts.click();
        return this;
    }
//    public HomeStep acessarHomeProducts(){
//        btnProducts.click();
//        return this;
//    }


}
