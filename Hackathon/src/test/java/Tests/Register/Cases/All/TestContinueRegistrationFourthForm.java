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

public class TestContinueRegistrationFourthForm {
    WebDriver chromeDriver;
    @BeforeMethod
    public void init(){
        chromeDriver = new WebDrivers().getDriver("chrome");
    }

    @Test (groups = "Regresion")
    public void flowTest() throws InterruptedException {
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
        Thread.sleep(50);
        inputField.sendKeys(RandomStringUtils.randomAlphabetic(40));
        nextBtn.click();
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(rv.getAcademyXpath())));
        Thread.sleep(250);
        nextBtn.click();
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(rv.getSubmitTwoBtnId())));
        nextBtn.click();

        for (int i=1;i<11;i++){
            nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"skillForm\"]/div[1]/div["+i+"]/label")));
            Thread.sleep(250);
            nextBtn.click();
        }

        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(rv.getSubmitThreeBtnId())));
        Thread.sleep(50);
        nextBtn.click();
        Thread.sleep(50);
        chromeDriver.navigate().back();
        Thread.sleep(50);
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(rv.getRegisterHereXpath())));
        nextBtn.click();

        inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(rv.getFormFourId())));


        Thread.sleep(250);

        Assert.assertTrue(inputField.isDisplayed());

    }

    @AfterMethod
    void tearDown(){

        chromeDriver.quit();

    }


}

