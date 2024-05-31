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
        btnLogin.click();
        return this;
    }
    public HomeStep loginHome(String email, String password){
    campoEmail.sendKeys(email);
    campoPassword.sendKeys(password);
        return this;
    }
}
