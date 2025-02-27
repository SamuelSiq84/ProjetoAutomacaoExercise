package steps;

import maps.HomeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;


public class HomeStep extends HomeMap {
    public HomeStep(WebDriver driver) {
        super(driver);
    }
    HomeMap homeMap = new HomeMap(driver);

    public HomeStep acessarURL(String url){
        System.out.println("Acessar a URL");
    driver.get(url);
    return this;
    }
    public HomeStep acessarLoginPage(){
        System.out.println("Acessando Login na Home Page");
    btnLoginHome.click();
    return this;
    }
    public HomeStep loginHome(String email, String password){
        System.out.println("Preenchendo email: " + email + " e password: " + password);
    campoEmail.sendKeys(email);
    campoPassword.sendKeys(password);
        System.out.println("Clicando no botão submit do Login");
    btnSubmit.click();
    return this;
    }
    public HomeStep validarLogin(String nome){
        driver.findElement(By.xpath("//b[contains(text(), '" + nome + "')]"));
        return this;
    }
    public HomeStep acessarHomeProducts(){
        System.out.println("Acessando pela Home a products");
        btnProducts.click();
        return this;
    }
//    public HomeStep acessarHomeProducts(){
//        btnProducts.click();
//        return this;
//    }


}
