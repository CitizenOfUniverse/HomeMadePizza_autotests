import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class HMP_UI_Autotests {
    @BeforeClass
    public static void before(){
        Configuration.browser="firefox";
        Configuration.browserSize="1366x768";
    }

    @Test
    public void test1(){
        open("http://localhost:3000/");
    }
}
