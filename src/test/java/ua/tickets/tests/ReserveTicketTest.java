package ua.tickets.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.tickets.models.Contact;
import ua.tickets.models.User;
import ua.tickets.pageElements.SearchBlock;
import ua.tickets.pageElements.TripAirlineDescription;
import ua.tickets.pages.AirlineReservation;
import ua.tickets.pages.MyTickets;
import ua.tickets.pages.ResultSearch;

public class ReserveTicketTest extends BaseTest {

    private User testUser = User.createRandomUser();

    private Contact contact = Contact.getRandomContact();

    private  TripAirlineDescription  trip;

    @BeforeMethod
    public void preCondition(){
        ResultSearch resultSearch =
                openMainPage()                                                       //#1,2
                        .searchBlock
                        .typeStartDate(5)                                            // #6
                        .typeFrom("MOW")                                             // #4
                        .typeToWhere("LON")                                          // #5
                        .selectTravelType(SearchBlock.TypeTravelling.ONE_WAY)        // #3
                        .selectTicketClass(SearchBlock.TypeTicketClass.ANY_CLASS)    // #8
                        .clickOnPersonCount()
                        .typePersonCount(1,1)                     // #7
                        .clickBtnSearch();                                           // #9,10

    }

    @Test
    public void reserveTicket() {
        ResultSearch resultSearch = new ResultSearch();

        trip =   resultSearch.chooseAirline(1).getTripDescription(1);               //#1
        MyTickets myTickets =
                resultSearch
                .clickBtnSubmitTrip(1)                                          //#2
                .fillUserForm(testUser)                                               //#5
                .fillContactForm(contact)                                             //#3
                .selectGender(AirlineReservation.Gender.MALE)
                .clickBtnBookTicket()                                                 //#6
                .selectPaymentSystemEuroset()                                         //#7
                .clickBtnSubmitPuyment()
                .clickBtnSubmitPayment()
                .clickBtnBackToOrder();                                               //#9

        String FIO = myTickets.getFIOinUppercase();
        String tripNumber = myTickets.getTripNumber();

        Assert.assertEquals(tripNumber, trip.getTripNumber());
        Assert.assertEquals(FIO, testUser.getLastName().toUpperCase()+" " +testUser.getFirstName().toUpperCase()); //#9

    }

}
