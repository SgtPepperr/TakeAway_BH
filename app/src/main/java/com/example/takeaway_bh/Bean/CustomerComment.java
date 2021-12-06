package com.example.takeaway_bh.Bean;

import org.litepal.crud.LitePalSupport;

public class CustomerComment extends LitePalSupport {
    private String head, username, rank_text;
    private int rank;
    private long time;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRank_text() {
        return rank_text;
    }

    public void setRank_text(String rank_text) {
        this.rank_text = rank_text;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

}
