package com.myPackage;

public class HotelInfo {
    public String name;
    public int price;
    public int rating;

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public HotelInfo(String name, int price,int rating) {
        this.name=name;
        this.price=price;
        this.rating=rating;
    }

    @Override
    public String toString() {
        return "HotelInfo{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
