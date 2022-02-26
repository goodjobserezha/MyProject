package HomeWork6;

import NewHomeWork5.Test11;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Test114 extends Test11 {

    @Test
    @DisplayName("Добавление товара в корзину")
    void addProduct() {
        Actions add = new Actions(getDriver());
        add.click(getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light")))
                .click(getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")))
                .build()
                .perform();

        Assertions.assertFalse(equals(getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"))), "Товар не добавлен");

    }

    @Test
    @DisplayName("Оформление заказа")
    void makeInOrder() {
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
    void twitterTitle() {
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

    @Test
    @DisplayName("Переход на Linkedin")
    void LinkedinTitle() {
        Actions title = new Actions(getDriver());
        title.click(getDriver().findElement(By.xpath(".//*[@class=\"shopping_cart_container\"]/a")))
                .build()
                .perform();
        Actions titlePhace = new Actions(getDriver());
        titlePhace.click(getDriver().findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getTitle().equals("Swag Labs"), "Заказ не оформлен");
    }

    @Test
    @DisplayName("Сортировка по цене")
    void SortingTest() {
        Actions title = new Actions(getDriver());
        title.click(getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")))
                .build()
                .perform();
        Actions titlePhace = new Actions(getDriver());
        titlePhace.click(getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/span")))
                .build()
                .perform();
        Actions titlePtitlePaceace = new Actions(getDriver());
        titlePtitlePaceace.click(getDriver().findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")))
                .build()
                .perform();
        Assertions.assertTrue(getDriver().getTitle().equals("Swag Labs"), "Price (low to high");
    }
}
