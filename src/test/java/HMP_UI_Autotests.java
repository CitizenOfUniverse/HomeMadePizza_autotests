import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import java.lang.StringBuilder;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class HMP_UI_Autotests {
    @BeforeClass
    public static void before(){
        Configuration.browser="firefox";
        Configuration.browserSize="1366x768";
    }

//    @Test
//    public void test1(){
//        open("http://localhost:3000/");
//        $(By.id("menu_item_button_text")).click();
//        $(By.id("menu_item_button_text")).shouldHave(Condition.text("В корзине (1)"));
//        sleep(3000);
//    }

    @Test
    public void test_case14_Ivan(){
        open("http://localhost:3000/");
        $(By.id("menu_item_button_text")).click();
        // Opening basket
        $(By.id("basket_icon")).click();
        $(By.id("nameInputID")).sendKeys("EPAM");
        $(By.id("phoneInputID")).sendKeys("+79990006611");
        $(By.id("addressInputID")).sendKeys("г. Тверь, ул. Колодкина, 8");
        $(By.id("needChangeFromID")).sendKeys("-8qwerty");
        $(By.id("order_submit_button")).click();
        $(By.id("changeFrom_error")).shouldBe(Condition.text("Сумма для сдачи должна быть целым положительным числом, не более 5000"));
    }

    @Test
    public void test_case16_Ivan(){
        open("http://localhost:3000/");
        //$(By.id("menu_item_button_text")).click();
        // Opening basket
        $(By.id("basket_icon")).click();
        $(By.id("cart_shadow_block")).shouldBe(Condition.appear);
        $(By.id("cart_close_button")).click();
        $(By.id("cart_shadow_block")).shouldBe(Condition.disappear);
    }

    @Test
    public void test_case20_Ivan(){
        open("http://localhost:3000/");
        $(By.id("menu_item_button_text")).click();
        $(By.id("menu_item_button_text")).click();
        // Opening basket
        $(By.id("basket_icon")).click();
        $(By.id("item_quantity_basket")).shouldBe(Condition.text("2"));
        $(By.id("item_minus_button")).click();
        $(By.id("item_quantity_basket")).shouldBe(Condition.text("1"));
    }

    @Test
    public void test_case21_Ivan(){
        open("http://localhost:3000/");
        $(By.id("menu_item_button_text")).click();
        // Opening basket
        $(By.id("basket_icon")).click();
        $(By.id("item_quantity_basket")).shouldBe(Condition.text("1"));
        $(By.id("item_minus_button")).click();
        $(By.id("item_basket_block")).shouldBe(Condition.disappear);
    }

    @Test
    public void test_case22_Ivan() {
        open("http://localhost:3000/");
        //$(By.id("menu_item_button_text")).click();
        // Opening basket
        $(By.id("basket_icon")).click();
        StringBuilder sendingString = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            sendingString.append('A');
        }
        $(By.id("nameInputID")).sendKeys(sendingString.toString());
        $(By.id("order_submit_button")).click();
        $(By.id("name_error")).shouldBe(Condition.text("Длина имени не должна превышать 128 символов"));
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
