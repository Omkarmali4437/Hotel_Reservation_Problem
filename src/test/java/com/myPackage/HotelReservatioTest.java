package com.myPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.myPackage.HotelReservation.hotelInfos;

public class HotelReservatioTest {
    HotelReservation hotelReservation;

    @Before
    public void setup(){
        hotelReservation=new HotelReservation();
    }

    HotelInfo lakewood =new HotelInfo("Lakewood",110,3);
    HotelInfo bridgewood =new HotelInfo("Bridgewood",160,4);
    HotelInfo ridgewood =new HotelInfo("Ridgewood",220,5);

    @Test
    public void inserting_Hotel_True_if_inserted(){
        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

        Assert.assertTrue(hotelInfos.contains(lakewood));
        Assert.assertTrue(hotelInfos.contains(bridgewood));
        Assert.assertTrue(hotelInfos.contains(ridgewood));

        hotelInfos.forEach(System.out::println);
    }
}
