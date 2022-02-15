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
            chromeDriver = new ChromeDriver();
            chromeDriver.manage().window().maximize();
            return chromeDriver;
        }
        if(driver == "edge"){
            WebDriverManager.edgedriver().setup();
            edgeDriver.manage().window().maximize();
            edgeDriver = new EdgeDriver();
            chromeDriver.manage().window().maximize();
            return edgeDriver;
        }
        if(driver == "firefox"){
            WebDriverManager.firefoxdriver().setup();
            firefoxDriver.manage().window().maximize();
            firefoxDriver = new FirefoxDriver();
            chromeDriver.manage().window().maximize();
            return firefoxDriver;
        }
        if(driver == "opera"){
            operaDriver.manage().window().maximize();
            WebDriverManager.operadriver().setup();
            operaDriver = new OperaDriver();
            chromeDriver.manage().window().maximize();
            return operaDriver;
        }

        return null;
    }






}
