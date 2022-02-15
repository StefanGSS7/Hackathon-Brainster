package Tests.Login;

import org.openqa.selenium.By;

public class LoginVariables {
    public static final String BASE_URL = "https://app2.arsovski.dev";
    public static final String HOME_PAGE_URL = "https://app2.arsovski.dev/home#page=1?academy=0";
    public static final String REGISTER_PAGE_URL = "https://app2.arsovski.dev/register";
    public static final By EMAIL_INPUT_FIELD = By.id("email");
    public static final By PASSWORD_INPUT_FIELD = By.id("password");
    public static final By LOGIN_BUTTON = By.xpath("/html/body/div/div/div[2]/div/form/div[3]/button");
    public static final By REGISTER_HERE_BUTTON = By.xpath("/html/body/div/div/div[2]/div/form/div[4]/p/a");
}
