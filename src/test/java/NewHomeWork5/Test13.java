package NewHomeWork5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Test13 extends Test12 {
    @Test
    @DisplayName("Авторизация на сайте")
    void myLoginTest() {
        Actions loginIn = new Actions(getDriver());
        loginIn.sendKeys(getDriver().findElement(By.id("user-name")), "standard_user")
                .click(getDriver().findElement(By.id("password")))
                .sendKeys("secret_sauce")
                .click(getDriver().findElement(By.id("login-button")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getTitle().equals("Swag Labs"), "Выполнена авторизация");



    }
}