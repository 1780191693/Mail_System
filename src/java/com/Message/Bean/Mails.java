package com.Message.Bean;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.Arrays;

public class Mails {

    private String Address;
    private String Title;
    private String Content;

    public Mails() {
    }

    public Mails(String address, String title, String content) {
        Address = address;
        Title = title;
        Content = content;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address){
        Address = address;
    }

//    public void setAddress(String address) throws AddressException {
//        String[] ad = address.split(";");
//        for (int i = 0; i < ad.length; i++) {
//            Address[i] = new InternetAddress(ad[i]);
//        }
//        System.out.println(Address);
//    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "Mails{" +
                "Address='" + Address + '\'' +
                ", Title='" + Title + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }
}
