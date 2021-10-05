package com.kali;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {
    private int cid = new Random().nextInt(200000) + 100000;
    private int id;
    private int consumer;
    private List<Menu> list = new ArrayList<>();

    public Customer(int id, int consumer) {
        this.id = id;
        this.consumer = consumer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsumer() {
        return consumer;
    }

    public void setConsumer(int consumer) {
        this.consumer = consumer;
    }

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
