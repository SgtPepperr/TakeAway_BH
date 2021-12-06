package com.example.takeaway_bh.Bean;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Store extends LitePalSupport {
    @Column(unique = true)
    private String StoreName;
    private int imageId;
    private String introduction;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

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
