package Tests.Register.Cases.All;


import Tests.Register.RegisterVariables;
import Tests.WebDrivers;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestAcademySelectionOnlyOne {

    WebDriver chromeDriver;
    @BeforeMethod
    public void init(){
        chromeDriver = new WebDrivers().getDriver("chrome");
    }

    @Test (groups = "Regresion")
    public void validCredentials() throws InterruptedException {
        RegisterVariables rv = new RegisterVariables();

        chromeDriver.get(rv.getBaseURL());

        WebDriverWait wait = new WebDriverWait(chromeDriver,10);

        WebElement nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(rv.getRegisterHereXpath())));
        nextBtn.click();
        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(rv.getUserNameId())));
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(rv.getSubmitOneBtnId())));



        inputField.sendKeys(RandomStringUtils.randomAlphabetic(10));
        inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(rv.getSureNameId())));
        inputField.sendKeys(RandomStringUtils.randomAlphabetic(10));
        inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(rv.getEmailId())));
        inputField.sendKeys(RandomStringUtils.randomAlphabetic(10)+"@gmail.com");
        inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(rv.getPasswordId())));
        inputField.sendKeys(RandomStringUtils.randomAlphanumeric(12));
        inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(rv.getBiographyId())));
        Thread.sleep(250);
        inputField.sendKeys(RandomStringUtils.randomAlphabetic(40));
        nextBtn.click();
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"formTwo\"]/div/div[2]/form/div[1]/div[3]/label")));
        Thread.sleep(350);
        nextBtn.click();
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"formTwo\"]/div/div[2]/form/div[1]/div[4]/label")));
        Thread.sleep(250);
        nextBtn.click();


        WebElement form = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(rv.getFormThreeId())));

        Thread.sleep(250);

        Assert.assertTrue(!chromeDriver.findElement(By.xpath("//*[@id=\"formTwo\"]/div/div[2]/form/div[1]/div[3]/label")).isSelected());


    }

    @AfterMethod
    void tearDown(){

        chromeDriver.quit();

    }


}

