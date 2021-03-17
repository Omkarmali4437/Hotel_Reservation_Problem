package com.myPackage;

public class HotelInfo {
    public String name;
    public int weekdayrate;
    public int weekendrate;
    public int rating;
    private int totalRate;

    public int getWeekdayrate() {
        return weekdayrate;
    }

    public int getWeekendrate() {
        return weekendrate;
    }

    public String getName() {
        return name;
    }

    public int  getRating(){
        return rating;
    }

    public HotelInfo(String name, int weekdayrate,int weekendrate,int rating) {
        this.name=name;
        this.weekdayrate = weekdayrate;
        this.weekendrate = weekendrate;
        this.rating=rating;
    }

    public int totalRate(){
        this.totalRate=weekdayrate+weekendrate;
        return totalRate;
    }

    @Override
    public String toString() {
        return "HotelInfo{" +
                "name='" + name + '\'' +
                ", Week Day rate=" + weekdayrate +
                ", Week End rate=" + weekendrate +
                '}';
    }

}
