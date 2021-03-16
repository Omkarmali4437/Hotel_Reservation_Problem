package com.myPackage;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelReservation {
    public static List<HotelInfo> hotelInfos=new ArrayList<>();

    public void addhotel(HotelInfo hotelInfo){
        hotelInfos.add(hotelInfo);
    }

    public HotelInfo findChepeatesthotel(LocalDate startdate,LocalDate enddate){
        long days= ChronoUnit.DAYS.between(startdate,enddate);
        HotelInfo min= Collections.min(hotelInfos,Comparator.comparing(hotelInfo->hotelInfo.price));
        int cheaprate;
        cheaprate=(int)(days*min.getPrice());
        System.out.println("Cheapest Hotel Name: "+ min.getName() + "\nTotal Rate: "+cheaprate);
        return min;
    }

}
