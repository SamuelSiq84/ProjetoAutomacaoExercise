package steps;

import maps.HomeMap;
import org.openqa.selenium.WebDriver;



public class HomeStep extends HomeMap {
    public HomeStep(WebDriver driver) {
        super(driver);
    }
    public HomeStep acessarURL(String url){
        driver.get(url);
        return this;
    }
}
