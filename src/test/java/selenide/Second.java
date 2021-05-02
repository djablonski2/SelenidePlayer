package selenide;

import Utilty.Utility;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static selenide.Fisrt_elements.*;

public class Second {

    @BeforeTest
    public void ustawienieKonfiguracji() {
        Configuration.timeout = 4000;
        Configuration.reportsFolder = "build\\reports\\tests";
        Configuration.baseUrl="https://the-internet.herokuapp.com";
    }

    @Test
    public void userCanOpenPage()  {

        open("/frames");
        $(byText("iFrame")).click();

        System.out.println($(By.cssSelector("h3")));
        Screenshots.takeScreenShot($(By.id("mce_0_ifr")));
        switchTo().frame($(By.id("mce_0_ifr")));
        $(By.id("tinymce")).sendKeys("TEST");
        switchTo().defaultContent();
        Screenshots.takeScreenShot($(By.id("mce_0_ifr")));
    }
}
