package com.myPackage;

public class HotelInfo {
    public String name;
    public int weekdayrate;
    public int weekendrate;
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

    public HotelInfo(String name, int weekdayrate,int weekendrate) {
        this.name=name;
        this.weekdayrate = weekdayrate;
        this.weekendrate = weekendrate;
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
