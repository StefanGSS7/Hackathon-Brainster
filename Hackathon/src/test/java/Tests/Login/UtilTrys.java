package Tests.Login;

import org.openqa.selenium.WebElement;

public class UtilTrys {

    public static void click_And_Send_Keys(WebElement webElement,String keys){
        webElement.click();
        webElement.sendKeys(keys);
    }

}
