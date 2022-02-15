package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeTest;


public class WebDrivers {

    WebDriver chromeDriver;
    WebDriver edgeDriver;
    WebDriver firefoxDriver;
    WebDriver operaDriver;
    @BeforeTest
    public WebDriver getDriver(String driver){

        if(driver == "chrome"){
            WebDriverManager.chromedriver().setup();
            this.chromeDriver = new ChromeDriver();
            return chromeDriver;
        }
        if(driver == "edge"){
            WebDriverManager.edgedriver().setup();
            this.edgeDriver = new EdgeDriver();
            return edgeDriver;
        }
        if(driver == "firefox"){
            WebDriverManager.firefoxdriver().setup();
            this.firefoxDriver = new FirefoxDriver();
            return firefoxDriver;
        }
        if(driver == "opera"){
            WebDriverManager.operadriver().setup();
            this.operaDriver = new OperaDriver();
            return operaDriver;
        }

        return null;
    }






}
