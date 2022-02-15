package Tests.Login.Cases;

import Tests.Login.LoginVariables;
import Tests.UtilTrys;
import Tests.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver chromeDriver;
    WebElement EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON, REGISTER_BUTTON;


    @BeforeMethod
    public void init() {
        chromeDriver = new WebDrivers().getDriver("chrome");
        chromeDriver.get(LoginVariables.BASE_URL);
        EMAIL_FIELD = chromeDriver.findElement(LoginVariables.EMAIL_INPUT_FIELD);
        PASSWORD_FIELD = chromeDriver.findElement(LoginVariables.PASSWORD_INPUT_FIELD);
        LOGIN_BUTTON = chromeDriver.findElement(LoginVariables.LOGIN_BUTTON);
        REGISTER_BUTTON = chromeDriver.findElement(LoginVariables.REGISTER_HERE_BUTTON);
    }

    @Test(description = "Verify if a user will be able to login with a valid username and valid password.", groups = "Flow")
    public void VERIFY_THAT_USER_CAN_LOGIN_WITH_VALID_CREDENTIALS() {
        UtilTrys.click_And_Send_Keys(EMAIL_FIELD, "stefan_kuzmanovski@hotmail.com");
        UtilTrys.click_And_Send_Keys(PASSWORD_FIELD, "asdqwe123");
        LOGIN_BUTTON.click();
        Assert.assertEquals(chromeDriver.getCurrentUrl(),LoginVariables.HOME_PAGE_URL);
    }

    @Test(description = "Verify that the user cannot login with invalid password", groups = "")
    public void VERIFY_THAT_USER_CANNOT_LOGIN_WITH_INVALID_PASSWORD() {
        UtilTrys.click_And_Send_Keys(EMAIL_FIELD, "stefan_kuzmanovski@hotmail.com");
        UtilTrys.click_And_Send_Keys(PASSWORD_FIELD, "asdqwe123aaa");
        LOGIN_BUTTON.click();
        Assert.assertNotEquals(chromeDriver.getCurrentUrl(),LoginVariables.HOME_PAGE_URL);
    }

    @Test(description = "Verify that the user cannot login with invalid email", groups = "")
    public void VERIFY_THAT_USER_CANNOT_LOGIN_WITH_INVALID_EMAIL() {
        UtilTrys.click_And_Send_Keys(EMAIL_FIELD, "staaaan_kuzmanovski@hotmail.com");
        UtilTrys.click_And_Send_Keys(PASSWORD_FIELD, "asdqwe123");
        LOGIN_BUTTON.click();
        Assert.assertNotEquals(chromeDriver.getCurrentUrl(),LoginVariables.HOME_PAGE_URL);
    }

    @Test(description = "Verify that the user cannot login with email and password field blank", groups = "")
    public void VERIFY_THAT_USER_CANNOT_LOGIN_WITH_NO_INPUT_FOR_EMAIL_AND_PASSWORD() {
        LOGIN_BUTTON.click();
        Assert.assertNotEquals(chromeDriver.getCurrentUrl(),LoginVariables.HOME_PAGE_URL);
    }

    @Test(description = "Verify that the register here button directs to the first step of the Register Page", groups = "")
    public void VERIFY_THAT_REGISTER_HERE_BUTTON_REDIRECTS_THE_USER_TO_THE_REGISTER_PAGE() {
        REGISTER_BUTTON.click();
        Assert.assertNotEquals(chromeDriver.getCurrentUrl(),LoginVariables.REGISTER_PAGE_URL);
    }

    @AfterMethod
    public void finish() {
        chromeDriver.quit();
    }
}
