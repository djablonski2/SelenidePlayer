package selenide;

import Utilty.Utility;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import selenide.pages.player_pages;

public class Player {



    @BeforeTest
    public void ustawienieKonfiguracji() {
        Configuration.timeout = 4000;
        Configuration.reportsFolder = "build\\reports\\tests\\Player_"+Utility.timestamp();
        Configuration.baseUrl="https://player.pl";
        Configuration.startMaximized=true;
    }

    @Test
    public void userCanOpenPage() throws InterruptedException {

        open("/");
        $(byText("Zgadzam się")).click();
        $(byText("Zaloguj")).click();
        $(byText("Zaloguj się e-mailem")).click();
        $(By.name("login")).sendKeys(player_pages.usernameEmail);
        $(By.name("password")).sendKeys(player_pages.usernamePassword);
        $(By.cssSelector("div.arkose-captcha")).waitWhile(Condition.visible,4000);
        $(By.id("sign_in")).click();
        Screenshots.takeScreenShot("Zalogowanie_"+Utility.timestamp());//

        // TODO zastąpić kolekcją
        $(byText("svodsdk")).click();
        $(By.cssSelector("i.icon-dropdown-arrow.dropdown__toggle-icon")).click();
        $(byText("Wyloguj się")).click();
        Screenshots.takeScreenShot("Wylogowanie_"+Utility.timestamp());
    }
}
