package com.myPackage;


import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
    public static List<HotelInfo> hotelInfos=new ArrayList<>();

    public void addhotel(HotelInfo hotelInfo){
        hotelInfos.add(hotelInfo);
    }

}
