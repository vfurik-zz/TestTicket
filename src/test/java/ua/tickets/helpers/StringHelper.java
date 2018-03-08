package ua.tickets.helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class StringHelper {

        public static String getRandomString(int lenght){
            return RandomStringUtils.randomAlphabetic(lenght);
        }

        public static String getRandomEmail(){
            return getRandomString(10) + "@test123.test";
        }
}
