package ua.tickets.pageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ua.tickets.helpers.DateHelper;
import ua.tickets.pages.ResultSearch;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SearchBlock {


    public ResultSearch clickBtnSearch() {
        SelenideElement btnSearch = $(byXpath("//*[@data-uil='submit_search']"));
        if (isHotelNewTab()) {
            btnSearch.click();
            switchTo().window(1);
            return new ResultSearch();
        }
        btnSearch.click();
        return new ResultSearch();
    }

    public SearchBlock typeFrom(String from) {
        SelenideElement fieldFrom = $(byId("from_name"));
        fieldFrom.setValue(from);
        checkAutocomplete(from, 1);
        fieldFrom.pressEnter();
        return this;
    }

    public SearchBlock typeToWhere(String toWhere) {
        SelenideElement fieldToWhere = $(byId("to_name"));
        fieldToWhere.setValue(toWhere);
        checkAutocomplete(toWhere, 2);
        fieldToWhere.pressEnter();
        return this;
    }

    public SearchBlock selectTravelType(TypeTravelling type) {
        type.radioBtn.click();
        return this;
    }

    public SearchBlock typeStartDate(int monthDiff) {
        String date = DateHelper.getDate(monthDiff);
        String locatorID = "departure_date"; // locator of date field
//        $(byId(locatorID)).click();
        $(byId(locatorID)).shouldBe(Condition.visible);
        executeJavaScript("document.getElementById('" + locatorID + "').setAttribute('value', '" + date + "')");
        return this;
    }

    public SearchBlock selectTicketClass(TypeTicketClass typeTicketClass) {
        $(byId("Class_Select_chosen")).click(); // click on dropdown list
        typeTicketClass.valueInDropdownList.shouldBe(Condition.visible);
        typeTicketClass.valueInDropdownList.click();
        // check selected value
        $(byXpath("//*[@id='Class_Select_chosen']//span")).shouldHave(Condition.text(typeTicketClass.getType()));
        return this;
    }

    public SelectPersonPopup clickOnPersonCount() {
        $(byXpath("//*[@data-uil='quantity']")).click();
        return this.new SelectPersonPopup();
    }


    /**
     * Verify the first element in autocomplete
     * code - expected value
     * index - number of autocomplete, 1 - from, 2 - whereTo
     */
    private SearchBlock checkAutocomplete(String code, int index) {
        String firstElementInAutocomplete = "//*[contains(@class,'ui-autocomplete')][" + index + "]//*[contains(@class,'ui-menu')]//strong";
        $(byXpath(firstElementInAutocomplete)).shouldHave(Condition.text(code));
        return this;
    }

    private boolean isHotelNewTab() {
        return $(byId("hotels-new-tab")).isSelected();
    }


    public enum TypeTravelling {
        ONE_WAY("oneway"),
        BOTH_WAY("round_trip"),
        MULTIPLE_ROUTE("complex_flight");

        private TypeTravelling(String attrValue) {
            radioBtn = $(by("for", attrValue));
        }

        private SelenideElement radioBtn;

    }

    public enum TypeTicketClass {

        ANY_CLASS("Любой"),
        BUSINESS_CLASS("Бизнес"),
        ECONOMY_CLASS("Эконом");

        private TypeTicketClass(String type) {
            this.type = type;
            valueInDropdownList = $(byXpath(generateLocator(type)));
        }

        public String getType() {
            return type;
        }

        private String type;

        private SelenideElement valueInDropdownList;

        private String generateLocator(String type) {
            return "//*[@class='chosen-results']//*[text()='" + type + "']";
        }

    }

    public class SelectPersonPopup {

        public SelectPersonPopup() {
            // check visability of popup
            $(byXpath("//*[contains(@class,'persons-select-popup')]")).shouldBe(Condition.visible);
        }

        /**
         * @param typeOfPerson 1 - adult
         *                     2 - children
         *                     3 - baby
         */
        public SelectPersonPopup addPerson(int typeOfPerson) {
            $(byXpath("(//*[@class='number']//*[contains(@class,'plus')])" + "[" + typeOfPerson + "]")).click();
            return this;
        }

        public SelectPersonPopup substractPerson(int typeOfPerson) {
            $(byXpath("(//*[@class='number']//*[contains(@class,'minus')])" + "[" + typeOfPerson + "]")).click();
            return this;
        }


        public SearchBlock typePersonCount(int count, int typeOfPerson) {
            clickOnPersonCount();
            SelenideElement field = $(byXpath("(//*[@class='number']//input)" + "[" + typeOfPerson + "]"));
            field.setValue(Integer.toString(count));
            return SearchBlock.this;
        }

        public SelectPersonPopup verifyTotalPersonCount(int expectedCount) {
//            not implemented yet
            return null;
        }


    }

}
