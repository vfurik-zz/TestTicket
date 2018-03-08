package ua.tickets.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byXpath;

public class PopupPaymentInEuroSet {

    public MyTickets clickBtnBackToOrder(){
        $(byText("Вернуться к заказу")).waitUntil(Condition.visible, 40000).click();
        return new MyTickets();
    }

}
