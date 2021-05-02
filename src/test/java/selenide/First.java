package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;
import static selenide.Fisrt_elements.*;

public class First {

    @BeforeTest
    public void ustawienieKonfiguracji() {
        Configuration.timeout = 4000;
        Configuration.reportsFolder = "build\\reports\\tests";
        Configuration.baseUrl="https://the-internet.herokuapp.com";
    }

    @Test
    public void userCanOpenPage() throws InterruptedException {

        open("/");
        $(byText("Form Authentication")).click();

        System.out.println($(By.cssSelector(".subheader")));
        Screenshots.takeScreenShot($(By.cssSelector(".subheader")));

        input_Login.sendKeys("tomsmith");
        input_Haslo.sendKeys("SuperSecretPassword!");
        btn_Zaloguj.click();


        $(".flash.success").shouldHave(text("You logged into a secure area!"));
        $(".subheader").shouldHave(text("Welcome to the Secure Area. When you are done click logout below."));
        $(".button.secondary.radius").shouldBe(exist);

        $(byText("Logout")).click();

//        System.out.println(url());
//        System.out.println(title());
//        System.out.println(source());

        open("/checkboxes");
//        $(byText("checkbox 1")).setSelected(true);
//        $(byText("checkbox 2")).setSelected(false);
        $$("input[type=checkbox]").shouldHaveSize(2);
    //    $$("input[type=checkbox]").shouldHave(exactTexts("checkbox 1", "chekbox 2"));

        $$("input[type=checkbox]").get(0).click();
        $$("input[type=checkbox]").get(1).click();
        Thread.sleep(3000);
    }
}
