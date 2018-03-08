package ua.tickets.pageElements;

import java.io.Serializable;
import java.util.Objects;


public class TripAirlineDescription implements Serializable {

    public TripAirlineDescription(String tripNumber, String price) {
        this.tripNumber = tripNumber;
        this.price = price;
    }

    private String tripNumber;

    private String price;

    public String getTripNumber() {
        return tripNumber;
    }

    public String getPrice() {
        return price;
    }

    // not implemented yet for all other fields (like city, departureTime, arrivalTime e.t.c )

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripAirlineDescription that = (TripAirlineDescription) o;
        return Objects.equals(tripNumber, that.tripNumber) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripNumber, price);
    }


    @Override
    public String toString() {
        return "TripAirlineDescription{" +
                "tripNumber='" + tripNumber + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
