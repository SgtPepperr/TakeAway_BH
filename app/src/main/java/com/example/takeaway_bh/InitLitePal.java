package com.example.takeaway_bh;

import com.example.takeaway_bh.Bean.Good;
import com.example.takeaway_bh.Bean.Store;
import com.example.takeaway_bh.Bean.User;

public class InitLitePal{

    public void init() {
        setUser("123456","123456",false);
        setStore("store1",R.drawable.apple_pic,"no intro");
        setStore("store2",R.drawable.banana_pic,"no intro");
        setStore("store3",R.drawable.banana_pic,"no intro");
        setStore("store4",R.drawable.banana_pic,"no intro");
        setStore("store5",R.drawable.banana_pic,"no intro");
        setStore("store6",R.drawable.banana_pic,"no intro");
        setStore("store7",R.drawable.banana_pic,"no intro");
        setStore("store8",R.drawable.banana_pic,"no intro");
        setStore("store9",R.drawable.banana_pic,"no intro");
        setStore("store10",R.drawable.banana_pic,"no intro");
        setGood("apple","this is an apple","store1",R.drawable.apple_pic,2);
        setGood("banana","this is a banana","store1",R.drawable.banana_pic,Float.parseFloat("1.5"));
        setGood("apple","this is an apple","store2",R.drawable.apple_pic,3);
    }

    public void setUser(String name,String password,Boolean b) {
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setRider(b);
        user.save();
    }

    public void setStore(String name,int image,String intro) {
        Store store = new Store();
        store.setStoreName(name);
        store.setImageId(image);
        store.setIntroduction(intro);
        store.save();
    }

    public void setGood(String name,String intro,String storeName, int image,float price) {
        Good good = new Good();
        good.setName(name);
        good.setIntroduction(intro);
        good.setStoreName(storeName);
        good.setImageId(image);
        good.setPrice(price);
        good.save();
    }
}
