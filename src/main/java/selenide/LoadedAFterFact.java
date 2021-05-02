package selenide;

import Utilty.Utility;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoadedAFterFact {

    @BeforeTest
    public void ustawienieKonfiguracji() {
        Configuration.timeout = 4000;
        Configuration.reportsFolder = "build\\reports\\tests\\";
        Configuration.baseUrl="https://the-internet.herokuapp.com";
    }

    @Test
    public void userCanOpenPage() throws InterruptedException {

        open("/dynamic_loading");
        $(byText("Example 2: Element rendered after the fact")).click();
        $(byText("Start")).click();
        $(By.id("loading")).shouldBe(Condition.visible);
        Screenshots.takeScreenShot("fileName"+Utility.timestamp());
        $(By.id("finish")).waitUntil(Condition.visible,10000);
        Screenshots.takeScreenShot("fileName2");

    }
}
