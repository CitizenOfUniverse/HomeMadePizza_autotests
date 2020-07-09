import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;

public class Nikita_Autotests_Btn_Counter {
    @BeforeClass
    public static void before(){
        Configuration.browser="chrome";
        Configuration.browserSize="1366x768";
    }

    @Test
    public void test1()
    {
        open("http://localhost:3000/");
        element(byId("menu_item_add_to_basket_button")).click();
        element(byId("menu_item_button_text")).shouldHave(text("В корзине (1)"));
    }
}
