package selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Fisrt_elements {
    public static final WebElement input_Login = $(By.name("username"));
    public static final WebElement input_Haslo = $(By.name("password"));
    public static final WebElement btn_Zaloguj = $(byText("Login"));

}
