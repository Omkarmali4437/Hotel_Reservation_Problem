package com.myPackage;

public class HotelInfo {
    public String name;
    public int weekdayrate;
    public int weekendrate;
    public int rating;
    private int weekdayRewardRate;
    private int weekendRewardRate;
    private int totalRate=0;

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

    public HotelInfo(String name, int weekdayrate,int weekendrate,int rating,int weekdayRewardRate,int weekendRewardRate) {
        this.name=name;
        this.weekdayrate = weekdayrate;
        this.weekendrate = weekendrate;
        this.weekdayRewardRate=weekdayRewardRate;
        this.weekdayRewardRate=weekdayRewardRate;
        this.rating=rating;
    }

    public int gettotalRate(){
        return totalRate;
    }

    public void setTotalRate(int totalRate){
        this.totalRate=totalRate;
    }

    public int getWeekdayRewardRate() {
        return weekdayRewardRate;
    }

    public void setWeekdayRewardRate(int weekdayRewardRate) {
        this.weekdayRewardRate = weekdayRewardRate;
    }

    public int getWeekendRewardRate() {
        return weekendRewardRate;
    }

    public void setWeekendRewardRate(int weekendRewardRate) {
        this.weekendRewardRate = weekendRewardRate;
    }

    @Override
    public String toString() {
        return "HotelInfo{" +
                "name='" + name + '\'' +
                ", weekdayrate=" + weekdayrate +
                ", weekendrate=" + weekendrate +
                ", rating=" + rating +
                '}';
    }
}


