package ua.tickets.pages;

import com.codeborne.selenide.SelenideElement;
import ua.tickets.models.Contact;
import ua.tickets.models.User;

import java.time.LocalDate;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.by;
public class AirlineReservation {

    public AirlineReservation fillUserForm(User user) {
        typeFirstName(user.getFirstName());
        typeLastName(user.getLastName());
        typeBthd(user.getBrthd());
        selectNationality(user.getNationality());
        typePassCE(user.getPassCE());
        typeExpireDate(user.getExpireDate());
        return this;
    }

    public AirlineReservation fillContactForm(Contact contact) {
        typeEmail(contact.getEmail());
//        typePhoneCode(contact.getCode());
        typePhoneNumber(contact.getPhoneNumber());
        return this;
    }

    public AirlineReservation selectGender(Gender gender){
        gender.radioBtn.click();
        return this;
    }

    public CheckoutPage clickBtnBookTicket(){
        $(byXpath("//*[contains(@data-uil,'to_pay')]")).click();
        return new CheckoutPage();
    }

    /**************** Contacts information ***************/

    private AirlineReservation typeEmail(String email) {
        SelenideElement emailField = $(byId("email"));
        emailField.setValue(email);
        return this;
    }

    private AirlineReservation typePhoneCode(int code) {
        $(byId("phone_code_field_chosen")).selectOptionByValue(Integer.toString(code));
        return this;
    }

    private AirlineReservation typePhoneNumber(int phone) {
        $(byId("phone_number_field")).setValue(Integer.toString(phone));
        return this;
    }


    /**************** Passenger Information  ***************/

    private AirlineReservation typeLastName(String lastName) {
        $(byId("lastname_0")).setValue(lastName);
        return this;
    }

    private AirlineReservation typeFirstName(String firstName) {
        $(byId("firstname_0")).setValue(firstName);
        return this;
    }

    private AirlineReservation typeBthd(LocalDate localDate) {
        $(byId("birthday_day_0")).setValue(Integer.toString(localDate.getDayOfMonth()));
        $(byId("birthday_month_0")).setValue(Integer.toString(localDate.getMonthValue()));
        $(byId("birthday_year_0")).setValue(Integer.toString(localDate.getYear()));
        return this;
    }


    private AirlineReservation selectNationality(User.Nationality nationality) {
        $(byId("citizenship_name_0")).selectOption(nationality.countryName);
        return this;
    }

    private AirlineReservation typePassCE(String passCE) {
        $(byId("docnum_0")).setValue(passCE);
        return this;
    }

    private AirlineReservation typeExpireDate(LocalDate localDate) {
        $(byId("doc_expire_date_day_0")).setValue(Integer.toString(localDate.getDayOfMonth()));
        $(byId("doc_expire_date_month_0")).setValue(Integer.toString(localDate.getMonthValue()));
        $(byId("doc_expire_date_year_0")).setValue(Integer.toString(localDate.getYear()));
        return this;
    }

    public enum Gender {
        MALE("passengers_gender_0-M"),
        FEMALE("");

        private Gender(String attrValue){
            radioBtn = $(by("for", attrValue));
        }

        private SelenideElement radioBtn;
    }
}
