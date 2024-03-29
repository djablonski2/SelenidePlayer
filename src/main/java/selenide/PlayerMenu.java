package selenide;

import Utilty.Utility;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.annotations.Report;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.codeborne.selenide.testng.TextReport;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ TextReport.class})
@Report
public class PlayerMenu {

    private CharSequence usernameEmail = "svodsdk@player.mailinator.com";
    private CharSequence usernamePassword = "Tester22@";

    @BeforeTest
    public void ustawienieKonfiguracji() {
        Configuration.timeout = 4000;
        Configuration.reportsFolder = "build\\reports\\tests\\Player_"+Utility.timestamp();
        Configuration.baseUrl="https://player.pl";
        Configuration.startMaximized=true;
    }

    @Test
    public void userCanOpenPage()  {

        open("/");
        $(byText("Zgadzam się")).click();

        $$(By.cssSelector("div.menu-items-wrapper div.menu-item")).filterBy(Condition.visible)
                .shouldHave(CollectionCondition.size(9))
                .shouldHave(texts(
                        "Seriale",
                        "Programy",
                        "Filmy",
                        "Sport",
                        "discovery+",
                        "Kanały TV",
                        "Kolekcje",
                        "Mój player",
                        "Oferta"
                ));
        $(byText("Zaloguj")).hover();

        Screenshots.takeScreenShot("Menu_"+Utility.timestamp());
        Screenshots.takeScreenShot($(By.cssSelector("div.menu-desktop")));

    }
}
