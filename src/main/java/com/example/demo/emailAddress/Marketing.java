package com.example.demo.emailAddress;

public class Marketing {
    public static boolean isHotmailAddress(EmailAddress address) {
        return address.getDomain().equalsIgnoreCase("hotmail.com" );
    }
}
