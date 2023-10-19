package com.example.secondproject.model;

import java.time.LocalDate;
import java.util.List;

public class History {

    private Integer id;
    private String histories;

    private LocalDate now;

    private int data;

    public History() {
    }

    // Copy constructor
    public History(History other) {
        this.data = other.data;
    }


    public String getHistories() {
        return histories;
    }

    public void setHistories(String histories) {
        this.histories = histories;
    }

    public LocalDate getNow() {
        return now;
    }

    public void setNow(LocalDate now) {
        this.now = now;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
