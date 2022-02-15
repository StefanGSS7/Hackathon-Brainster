package Tests.Register.Cases.KeyFlow;

import Tests.Register.RegisterVariables;
import Tests.WebDrivers;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestPositiveFlow {
    RegisterVariables registerVariables = new RegisterVariables();
    WebDriver chromeDriver;

    @BeforeMethod
    public void init(){
        chromeDriver = new WebDrivers().getDriver("chrome");
    }


    @Test (description = "Register Positive Flow",groups = "Flow")
    public void flowTest() throws InterruptedException {
        chromeDriver.get(registerVariables.getBaseURL());

        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);

        WebElement nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(registerVariables.getRegisterHereXpath())));
        nextBtn.click();
        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registerVariables.getUserNameId())));
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registerVariables.getSubmitOneBtnId())));

        inputField.sendKeys(RandomStringUtils.randomAlphabetic(10));
        inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registerVariables.getSureNameId())));
        inputField.sendKeys(RandomStringUtils.randomAlphabetic(10));
        inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registerVariables.getEmailId())));
        inputField.sendKeys(RandomStringUtils.randomAlphabetic(10) + "@gmail.com");
        inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registerVariables.getPasswordId())));
        inputField.sendKeys(RandomStringUtils.randomAlphanumeric(12));
        inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registerVariables.getBiographyId())));
        Thread.sleep(50);
        inputField.sendKeys(RandomStringUtils.randomAlphabetic(40));
        nextBtn.click();
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(registerVariables.getAcademyXpath())));
        Thread.sleep(250);
        nextBtn.click();
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registerVariables.getSubmitTwoBtnId())));
        nextBtn.click();

        for (int i = 1; i < 11; i++) {
            nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"skillForm\"]/div[1]/div[" + i + "]/label")));
            Thread.sleep(250);
            nextBtn.click();
        }

        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registerVariables.getSubmitThreeBtnId())));
        Thread.sleep(50);
        nextBtn.click();
        Thread.sleep(50);
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registerVariables.getUploadImageXpath())));
        nextBtn.sendKeys("C:\\ProfileImage.jpg");
        Thread.sleep(50);
        nextBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(registerVariables.getSubmitFourBtnId())));
        nextBtn.click();

        Thread.sleep(250);

        Assert.assertEquals(chromeDriver.getCurrentUrl(), "https://app2.arsovski.dev/home#page=1?academy=0");

    }
    @AfterMethod
    void tearDown() {

        chromeDriver.quit();

    }
}

