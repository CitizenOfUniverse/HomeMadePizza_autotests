import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;



public class HMP_UI_Autotests {
    @BeforeClass
    public static void before(){
        Configuration.browser="chrome";
        Configuration.browserSize="1366x768";
    }

    @Test
    public void tests_case1() {
            open("http://localhost:3000/");
            element(byId("menu_item_add_to_basket_button")).click();
            element(byId("menu_item_button_text")).shouldHave(text("В корзине (1)"));
    }
    @Test
    public void tests_case2() {
        open("http://localhost:3000/");
        element(byId("menu_item_add_to_basket_button")).click();
        element(byId("menu_item_add_to_basket_button")).click();
        element(byId("menu_item_button_text")).shouldHave(text("В корзине (2)"));
        element(byId("menu_item_add_to_basket_button")).click();
        element(byId("menu_item_button_text")).shouldHave(text("В корзине (3)"));
        element(byId("menu_item_add_to_basket_button")).click();
        element(byId("menu_item_button_text")).shouldHave(text("В корзине (4)"));
    }
    @Test
    public void tests_case6() {
        open("http://localhost:3000/");
        element(byId("menu_item_add_to_basket_button")).click();
        element(byId("menu_item_button_text")).shouldHave(text("В корзине (1)"));
        element(byId("basket_icon")).click();
        element(byId("item_quantity_basket")).shouldHave(text("1"));
    }
    @Test
    public void tests_case7() {
        open("http://localhost:3000/");
        element(byId("menu_item_add_to_basket_button")).click();
        element(byId("menu_item_add_to_basket_button")).click();
        element(byId("basket_icon")).click();
        element(byId("item_quantity_basket")).shouldHave(text("2"));
        element(byId("cart_close_button")).click();
        element(byId("menu_item_add_to_basket_button")).click();
        element(byId("basket_icon")).click();
        element(byId("item_quantity_basket")).shouldHave(text("3"));
        element(byId("cart_close_button")).click();
    }
    @Test
    public void tests_case8() {
        open("http://localhost:3000/");
        $x("//div[@id='menu_item_card' and contains(.,'Мексиканская')]").$(By.id("menu_item_add_to_basket_button")).click();
        $x("//div[@id='menu_item_card' and contains(.,'От Шефа')]").$(By.id("menu_item_add_to_basket_button")).click();
        $x("//div[@id='menu_item_card' and contains(.,'Мексиканская')]").$(By.id("menu_item_button_text")).shouldHave(text("В корзине (1)"));
        $x("//div[@id='menu_item_card' and contains(.,'От Шефа')]").$(By.id("menu_item_button_text")).shouldHave(text("В корзине (1)"));
        element(byId("basket_icon")).click();
        $x("//div[@id='item_basket_block' and contains(.,'От Шефа')]").$(By.id("item_quantity_basket")).shouldHave(text("1"));
        $x("//div[@id='item_basket_block' and contains(.,'Мексиканская')]").$(By.id("item_quantity_basket")).shouldHave(text("1"));
    }
}
