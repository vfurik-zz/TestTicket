package ua.tickets.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ua.tickets.pageElements.TripAirlineDescription;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byXpath;

public class ResultSearch {

        public ResultSearch(){
            // check preload progress
//            $(byXpath("//*[@class='preloader_block']")).waitUntil(Condition.appear, 10000);
            // check result page loaded
            $(byXpath("//*[contains(@class,'active') and text()='Результаты поиска']")).waitUntil(Condition.appear, 30000);
        }


        public ResultSearch chooseAirline(int index){
            SelenideElement e = $(byXpath("(//*[contains(@id,'price_cell')])"+"[" + index + "]"));
            e.click();
            $(byXpath("//*[contains(@class,'ac_name there')]/span[1]")).shouldHave(Condition.text("Aeroflot"));
            return this;
        }


        /*********  Submit trip form *****/

        public AirlineReservation clickBtnSubmitTrip(int index){
            String locatorBtnSubmit = "(//*[contains(@class,'rec_submit')])" + "[" + index + "]";
            $(byXpath(locatorBtnSubmit)).click();

            return new AirlineReservation();
        }

        public TripAirlineDescription getTripDescription(int i){
            return new TripAirlineDescription(getTripNumber(i), getTripPrice(i));
        }

        private String getTripPrice(int index){
            String xpath = "(//*[contains(@class,'price-block right')]//*[contains(@class,'RUR')])" + "[" + index + "]";
            return $(byXpath(xpath)).getText().trim();
        }

        private String getTripNumber(int index){
            String locatorTripNUmber = "(//*[text()[contains(.,'Рейс')]]//strong)" + "[" + index + "]";
            return $(byXpath(locatorTripNUmber)).getText().trim();
        }


        public class ChooseTarrifPopup {

            public AirlineReservation clickBtnContinue(){
                $(byXpath("//*[contains(@class,'btn_change_ff')]")).click();
                return new AirlineReservation();
            }

        }

}


