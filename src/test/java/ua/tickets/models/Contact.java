package ua.tickets.models;

import ua.tickets.helpers.StringHelper;

import java.util.concurrent.ThreadLocalRandom;

public class Contact {

    private Contact(String email, int code, int phoneNumber) {
        this.email = email;
        this.code = code;
        this.phoneNumber = phoneNumber;
    }

    private String email;
    private int code;
    private int phoneNumber;

    public static Contact getRandomContact(){
        String email = StringHelper.getRandomEmail();
        int code = 380;
        int phoneNumber = ThreadLocalRandom.current().nextInt(100000000, 900000000);
        return new Contact(email, code, phoneNumber);
    }

    public String getEmail() {
        return email;
    }

    public int getCode() {
        return code;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (code != contact.code) return false;
        if (phoneNumber != contact.phoneNumber) return false;
        return email != null ? email.equals(contact.email) : contact.email == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + code;
        result = 31 * result + phoneNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", code=" + code +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
