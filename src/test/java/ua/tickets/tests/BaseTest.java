package ua.tickets.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import ua.tickets.pages.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeSuite
    public void initSuite() {
        init();
    }


    private void init() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "none";
        Configuration.timeout = 15000;
        Configuration.baseUrl = "https://tickets.ru";
    }

    public MainPage openMainPage() {
        open("/");
        clearBrowserCookies();
        return new MainPage();
    }


}


