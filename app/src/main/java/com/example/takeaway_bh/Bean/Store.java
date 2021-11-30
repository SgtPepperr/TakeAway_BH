package com.example.takeaway_bh.Bean;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Store extends LitePalSupport {
    @Column(unique = true)
    private String StoreName;
    private String introduction;

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
