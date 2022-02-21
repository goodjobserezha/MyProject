package HomeWork5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;



public class Test4 extends Test1{

    @Test
    @DisplayName("Добавление в корзину")
    void addProduct() {
        Actions add = new Actions(getDriver());
        add.click(getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light")))
                .click(getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")))
                .build()
                .perform();
        Assertions.assertFalse(equals(getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"))),"Товар не добавлен");
    }
    @Test
    @DisplayName("Удаление из корзины")
    void removeProduct() {
        Actions removePr = new Actions(getDriver());
        removePr.click(getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")))
                .click(getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")))
                .click(getDriver().findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")))
                .click(getDriver().findElement(By.id("checkout")))
                .click(getDriver().findElement(By.xpath(".//*[@class=\"shopping_cart_container\"]/a")))
                .build()
                .perform();
        Actions removePrTwo = new Actions(getDriver());
        removePrTwo.click(getDriver().findElement(By.id("remove-sauce-labs-backpack")))
                .click(getDriver().findElement(By.id("continue-shopping")))
                .build()
                .perform();

        Assertions.assertFalse(equals(getDriver().findElement(By.xpath(".//*[@class=\"shopping_cart_container\"]/a"))),"Товар не удален");
        Assertions.assertFalse(equals(getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"))),"Товар не удален");
    }

    @Test
    @DisplayName("Оформление заказа")
    void makeInOrder(){
        Actions Order = new Actions(getDriver());
        Order.click(getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")))
                .click(getDriver().findElement(By.xpath(".//*[@class=\"shopping_cart_container\"]/a")))
                .build()
                .perform();
        Actions OrderTwo = new Actions(getDriver());
        OrderTwo.click(getDriver().findElement(By.id("checkout")))
                .build()
                .perform();
        Actions OrderThree = new Actions(getDriver());
        OrderThree.click(getDriver().findElement(By.id("first-name")))
                .sendKeys("Sergey")
                .click(getDriver().findElement(By.id("last-name")))
                .sendKeys("Artamonov")
                .click(getDriver().findElement(By.id("postal-code")))
                .sendKeys("195299")
                .click(getDriver().findElement(By.id("continue")))
                .build()
                .perform();
        Actions OrderFour = new Actions(getDriver());
        OrderFour.click(getDriver().findElement(By.id("finish")))
                .build()
                .perform();
        Actions OrderFive = new Actions(getDriver());
        OrderFive.click(getDriver().findElement(By.id("back-to-products")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getTitle().equals("Swag Labs"), "Заказ не оформлен");
    }
    @Test
    @DisplayName("Переход на Tвиттер")
    void facebookTitle() {
        Actions title = new Actions(getDriver());
        title.click(getDriver().findElement(By.xpath(".//*[@class=\"shopping_cart_container\"]/a")))
                .build()
                .perform();
        Actions titlePhace = new Actions(getDriver());
        titlePhace.click(getDriver().findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getTitle().equals("Swag Labs"), "Заказ не оформлен");
    }
}