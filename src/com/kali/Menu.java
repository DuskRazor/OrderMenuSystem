package com.kali;

import java.util.Objects;

public class Menu {
    private int id;
    private String name;
    private double price;

    public Menu(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + price + "￥";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                Double.compare(menu.price, price) == 0 &&
                name.equals(menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
