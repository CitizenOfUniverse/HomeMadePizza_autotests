import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import java.lang.StringBuilder;

import static com.codeborne.selenide.Selenide.*;

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
    public void test_case22_Ivan(){
        open("http://localhost:3000/");
        //$(By.id("menu_item_button_text")).click();
        // Opening basket
        $(By.id("basket_icon")).click();
        StringBuilder sendingString=new StringBuilder();
        for(int i=0;i<500;i++){
            sendingString.append('A');
        }
        $(By.id("nameInputID")).sendKeys(sendingString.toString());
        $(By.id("order_submit_button")).click();
        $(By.id("name_error")).shouldBe(Condition.text("Длина имени не должна превышать 128 символов"));
    }
}
