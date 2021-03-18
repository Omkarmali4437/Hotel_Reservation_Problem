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

    public HotelInfo find_Chepeatesthotel_based_on_WeekDay(LocalDate startdate,LocalDate enddate){
        long days= ChronoUnit.DAYS.between(startdate,enddate);
        HotelInfo min= Collections.min(hotelInfos,Comparator.comparing(hotelInfo->hotelInfo.getWeekdayrate()));
        int cheaprate;
        cheaprate=(int)(days*min.totalRate());
        System.out.println("Cheapest Hotel Name based on week day: "+ min.getName() + "\nTotal Rate: "+cheaprate);
        return min;
    }

    public HotelInfo find_Chepeatesthotel_based_on_WeekEnd(LocalDate startdate,LocalDate enddate){
        long days= ChronoUnit.DAYS.between(startdate,enddate);
        HotelInfo min1= Collections.min(hotelInfos,Comparator.comparing(hotelInfo->hotelInfo.getWeekendrate()));
        int cheaprate;
        cheaprate=(int)(days*min1.totalRate());
        System.out.println("Cheapest Hotel Name based on week end: "+ min1.getName() + "\nTotal Rate: "+cheaprate);
        return min1;
    }

    public String find_best_rated_hotel_and_also_cheapest(){
        HotelInfo minbasedonweekdays= Collections.min(hotelInfos,Comparator.comparing(hotelInfo->hotelInfo.getWeekdayrate()));
        HotelInfo minbasedonweekends = Collections.min(hotelInfos,Comparator.comparing(hotelInfo->hotelInfo.getWeekendrate()));
        if(minbasedonweekdays.totalRate()== minbasedonweekends.totalRate()){
            if(minbasedonweekdays.rating> minbasedonweekends.rating) {
                return minbasedonweekdays.getName();
            }
            else{
                return minbasedonweekends.getName();
            }
        }
        else if(minbasedonweekdays.totalRate()> minbasedonweekends.totalRate()){
            if(minbasedonweekdays.rating> minbasedonweekends.rating) {
                return minbasedonweekdays.getName();
            }
            else{
                return minbasedonweekends.getName();
            }
        }
        else if(minbasedonweekdays.totalRate()> minbasedonweekends.totalRate()){
            if(minbasedonweekdays.rating< minbasedonweekends.rating) {
                return minbasedonweekdays.getName();
            }
            else{
                return minbasedonweekends.getName();
            }
        }
        return null;
    }
}
