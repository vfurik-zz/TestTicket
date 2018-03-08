package ua.tickets.pages;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byXpath;

public class CheckoutPage {

    public CheckoutPage selectPaymentSystemEuroset(){
        String locatorEuroSet = "//*[text()='В салоне «Евросеть»']";
        $(byXpath(locatorEuroSet)).click();
        return this;
    }

    public AdditionalService clickBtnSubmitPuyment(){
        $(byXpath("(//*[@data-uil='submit_payment'])[2]")).click();
        return new AdditionalService();
    }

}
