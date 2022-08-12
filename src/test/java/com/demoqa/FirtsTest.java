package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirtsTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";

        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void autoTest(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Kirill");
        $("#lastName").setValue("Chernyshov");
        $("#userEmail").setValue("user@email.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("7880852282");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionContainingText("1994");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--024").click();
        $(byText("Sports")).click();
        $("#subjectsInput").setValue("Computer science").pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg"));
        $("#currentAddress").setValue("Russia, Mosсow");
        //$(By.xpath("//h2[text()='" + form + "']//ancestor::div[@class='block-wrapper']")).scrollIntoView(false);
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-body").shouldHave(
                text("Kirill"),
                text("Chernyshov"),
                text("user@email.com"),
                text("Male"),
                text("7880852282"),
                text("24 May,1994"),
                text("Computer science"),
                text("Sports"),
                text("1.jpg"),
                text("Russia, Mosсow"),
                text("NCR Delhi") );
    }
}
