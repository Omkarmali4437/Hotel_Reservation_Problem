package com.myPackage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;

enum Customertype{
    Regular_customer,
    Reward_customer
}

public class HotelReservation {
    public static List<HotelInfo> hotelInfos=new ArrayList<>();
    Customertype type;

    public HotelReservation(Customertype type){
        this.type=type;
    }

    public int Size(){
        return hotelInfos.size();
    }

    public int typeCustomer(boolean weekday, int idxi) {
        if (type == Customertype.Regular_customer && weekday)
            return hotelInfos.get(idxi).getWeekdayrate();
        else if (type == Customertype.Regular_customer)
            return hotelInfos.get(idxi).getWeekdayrate();
        else if (type == Customertype.Reward_customer && weekday)
            return hotelInfos.get(idxi).getWeekdayrate();
        else
            return hotelInfos.get(idxi).getWeekdayrate();
    }

    public void addhotel(HotelInfo hotelInfo){
        hotelInfos.add(hotelInfo);
    }

    public HotelInfo find_Chepeatesthotelint(LocalDate startdate, LocalDate enddate){
        DayOfWeek dayOfWeek = DayOfWeek.of(startdate.get(ChronoField.DAY_OF_WEEK));
        DayOfWeek dayOfWeek1=DayOfWeek.of(enddate.get(ChronoField.DAY_OF_WEEK));

        int day=dayOfWeek.getValue();
        int day1=dayOfWeek1.getValue();

        int min=10000;
        HotelInfo cheap=hotelInfos.get(0);

        for(int i=1;i< hotelInfos.size();i++){
            int totalrate=0;
            if(day>1 && day<6 && day1>1 && day1<6){
                totalrate=totalrate+hotelInfos.get(i).getWeekdayrate();
            }
            else{
                totalrate=totalrate+hotelInfos.get(i).getWeekendrate();
            }
            hotelInfos.get(i).setTotalRate(totalrate);
            if(totalrate<min){
                if(cheap.getRating()<hotelInfos.get(i).getRating())
                {
                    cheap=hotelInfos.get(i);
                    min=totalrate;
                }

            }
        }
        return cheap;
    }

    public HotelInfo find_best_rated_hotel(LocalDate startdate,LocalDate enddate){
        long days= ChronoUnit.DAYS.between(startdate,enddate);
        HotelInfo min1= Collections.max(hotelInfos,Comparator.comparing(hotelInfo->hotelInfo.getRating()));
        System.out.println("Best rated Hotel is: "+ min1.getName());
        return min1;
    }



}
