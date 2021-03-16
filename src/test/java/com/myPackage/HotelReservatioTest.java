package com.myPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static com.myPackage.HotelReservation.hotelInfos;

public class HotelReservatioTest {
    HotelReservation hotelReservation;

    HotelInfo lakewood =new HotelInfo("Lakewood",110,90,3);
    HotelInfo bridgewood =new HotelInfo("Bridgewood",160,50,4);
    HotelInfo ridgewood =new HotelInfo("Ridgewood",220,150,5);

    @Before
    public void setup(){
        hotelReservation=new HotelReservation();

        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

    }


    @Test
    public void inserting_Hotel_True_if_inserted(){
        Assert.assertTrue(hotelInfos.contains(lakewood));
        Assert.assertTrue(hotelInfos.contains(bridgewood));
        Assert.assertTrue(hotelInfos.contains(ridgewood));

        hotelInfos.forEach(System.out::println);
    }

    @Test
    public void ability_to_find_cheapest_hotel(){
        LocalDate startdate=LocalDate.of(2020,10,10);
        LocalDate enddate=LocalDate.of(2020,10,11);

        HotelInfo cheapesthotel=hotelReservation.findChepeatesthotel(startdate,enddate);

        Assert.assertEquals("Lakewood",cheapesthotel.getName());
    }

    @Test
    public void ability_to_have_weekday_and_weekend_rates(){
        Assert.assertEquals(90,lakewood.getWeekendrate());
        Assert.assertEquals(50,bridgewood.getWeekendrate());
        Assert.assertEquals(150,ridgewood.getWeekendrate());
    }
}
