package com.example.takeaway_bh.Bean;

import org.litepal.crud.LitePalSupport;

public class TakeOrder extends LitePalSupport {
    private String customer_user, rider_user, sales_user, customer_text, rider_text, sales_text, name, receive_phone, address;
    private int customer_rank, rider_rank, sales_rank;
    private boolean receive, over, punctuality;
    private String takeorder_time, arrival_time;
    private float total_price;

    public String getCustomer_user() {
        return customer_user;
    }

    public void setCustomer_user(String customer_user) {
        this.customer_user = customer_user;
    }

    public String getRider_user() {
        return rider_user;
    }

    public void setRider_user(String rider_user) {
        this.rider_user = rider_user;
    }

    public String getSales_user() {
        return sales_user;
    }

    public void setSales_user(String sales_user) {
        this.sales_user = sales_user;
    }

    public String getCustomer_text() {
        return customer_text;
    }

    public void setCustomer_text(String customer_text) {
        this.customer_text = customer_text;
    }

    public String getRider_text() {
        return rider_text;
    }

    public void setRider_text(String rider_text) {
        this.rider_text = rider_text;
    }

    public String getSales_text() {
        return sales_text;
    }

    public void setSales_text(String sales_text) {
        this.sales_text = sales_text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceive_phone() {
        return receive_phone;
    }

    public void setReceive_phone(String receive_phone) {
        this.receive_phone = receive_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomer_rank() {
        return customer_rank;
    }

    public void setCustomer_rank(int customer_rank) {
        this.customer_rank = customer_rank;
    }

    public int getRider_rank() {
        return rider_rank;
    }

    public void setRider_rank(int rider_rank) {
        this.rider_rank = rider_rank;
    }

    public int getSales_rank() {
        return sales_rank;
    }

    public void setSales_rank(int sales_rank) {
        this.sales_rank = sales_rank;
    }

    public boolean isReceive() {
        return receive;
    }

    public void setReceive(boolean receive) {
        this.receive = receive;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public boolean isPunctuality() {
        return punctuality;
    }

    public void setPunctuality(boolean punctuality) {
        this.punctuality = punctuality;
    }

    public String getTakeorder_time() {
        return takeorder_time;
    }

    public void setTakeorder_time(String takeorder_time) {
        this.takeorder_time = takeorder_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }
}
