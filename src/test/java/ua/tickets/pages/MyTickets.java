package ua.tickets.pages;

import static com.codeborne.selenide.Selectors.*;

import static com.codeborne.selenide.Selenide.*;

public class MyTickets {



    public String getTripNumber(){
        String locatorTripNumber = "(//*[contains(@class,'flight-maininfo')]//li)[2]//strong";
        return $(byXpath(locatorTripNumber)).getText().trim();
    }


    public String getFIOinUppercase(){
        String locatorFio = "(//*[@data-label='ФИО'])[1]";
       return  $(byXpath(locatorFio)).getText().trim();
    }

}
