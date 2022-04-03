package selenide.actions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenide.pages.player_pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class player_actions {

    public static void przejscieDoZalogowania() {
        $(byText("Zaloguj")).click();

    }

    public static void uzupelnienieDanychLogowania() {
        $(byText("Zaloguj się e-mailem")).click();
        $(By.name("login")).sendKeys(player_pages.usernameEmail);
        $(By.name("password")).sendKeys(player_pages.usernamePassword);
    }

}
