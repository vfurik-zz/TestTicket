package ua.tickets.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byXpath;

public class AdditionalService {

    public PopupPaymentInEuroSet clickBtnSubmitPayment(){
        String locator = "(//*[@data-uil='submit_payment'])[1]";
        $(byXpath(locator)).click();
        return new PopupPaymentInEuroSet();
    }

}
