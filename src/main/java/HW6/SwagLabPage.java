package HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabPage extends AbstractPage{

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement button;

    @FindBy(id = "login_button_container")
    private WebElement loginList;

    public SwagLabPage(WebDriver driver){

        super(driver);
    }
}
