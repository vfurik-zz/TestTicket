package ua.tickets.models;

import ua.tickets.helpers.DateHelper;
import ua.tickets.helpers.StringHelper;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {

    private User(String firstName, String lastName, LocalDate brthd, Nationality nationality, String passCE, LocalDate expireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.brthd = brthd;
        this.nationality = nationality;
        this.passCE = passCE.toUpperCase();
        this.expireDate = expireDate;
    }

    private String firstName;

    private String lastName;

    private LocalDate brthd;

    private Nationality nationality;

    private String passCE;

    private LocalDate expireDate;



    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", brthd=" + brthd +
                ", nationality=" + nationality +
                ", passCE='" + passCE + '\'' +
                ", expireDate=" + expireDate +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (brthd != null ? !brthd.equals(user.brthd) : user.brthd != null) return false;
        if (nationality != user.nationality) return false;
        if (passCE != null ? !passCE.equals(user.passCE) : user.passCE != null) return false;
        return expireDate != null ? expireDate.equals(user.expireDate) : user.expireDate == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (brthd != null ? brthd.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (passCE != null ? passCE.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        return result;
    }

    public static User createRandomUser(){
        String firstName = StringHelper.getRandomString(10);
        String lastName = StringHelper.getRandomString(10);
        Nationality nationality = Nationality.RUS;
        LocalDate brthd = DateHelper.getRandomDate(LocalDate.of(1950, 01,1), LocalDate.now());
        String passCE = StringHelper.getRandomString(10);
        LocalDate validityPass = DateHelper.getRandomDate(LocalDate.now().plusMonths(1), LocalDate.of(2025, 01,01));
        return new User(firstName, lastName,brthd, nationality, passCE, validityPass);
    }

    public enum Nationality{
        UKR("Украина"),
        RUS("Россия"),
        FRA("Франция");

        private Nationality(String countryName){
            this.countryName = countryName;
        }

        public String countryName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBrthd() {
        return brthd;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public String getPassCE() {
        return passCE;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

}
