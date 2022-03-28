package com.example.recyclerview;
import java.util.ArrayList;

public class ContactData {
    public static String[][] data = new String[][]{
            {"Bebe Organic", "https://i.pinimg.com/originals/1b/b5/f1/1bb5f103436772c32ef4e79f8cdd2d40.jpg"},
            {"Kylie Baby", "https://i.pinimg.com/originals/e2/91/2e/e2912e5b88851aeef9c515b60bc6b94f.jpg"},
            {"Panacea Skincare", "https://i.pinimg.com/originals/e2/91/2e/e2912e5b88851aeef9c515b60bc6b94f.jpg"},
            {"Calm And Co", "https://i.pinimg.com/originals/6a/98/d2/6a98d2ad9e3a63bfc2af1491bda8e6ce.png"},
            {"in One's Skin", "https://i.pinimg.com/originals/6e/ba/60/6eba603e8c104d3692665ba53289a3a1.jpg"},
            {"Oat Serum", "https://i.pinimg.com/originals/9a/5b/88/9a5b88125e8ab4c6694f9602d7b21029.jpg"},
            {"Soul Sunday", "https://i.pinimg.com/originals/29/99/ad/2999ada195995826c6762a82cdf27cf3.jpg"},
            {"Terra Candle", "https://i.pinimg.com/originals/fb/0e/eb/fb0eeb2497ab52dc0b9dd0c71f659327.jpg"},
            {"Unbound Lab", "https://i.pinimg.com/originals/e3/0c/0f/e30c0fb7a371e6cc953f5ab6742338dc.jpg"},
            {"FFLow", "https://i.pinimg.com/originals/b0/a6/fb/b0a6fb26c51a848c10de949470c794b2.jpg"}
};
    public static ArrayList<Contact> getListData(){
        Contact contact = null;
        ArrayList<Contact> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++){
        contact = new Contact();
        contact.setName(data[i][0]);
        contact.setPhoto(data[i][1]);
        list.add(contact);
        }
        return list;
        }

}
