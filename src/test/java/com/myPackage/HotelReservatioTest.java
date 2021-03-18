package com.myPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static com.myPackage.HotelReservation.hotelInfos;

public class HotelReservatioTest {
    HotelReservation hotelReservation;

    HotelInfo lakewood =new HotelInfo("Lakewood",110,90,3);
    HotelInfo bridgewood =new HotelInfo("Bridgewood",150,50,4);
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

        HotelInfo cheapesthotel=hotelReservation.find_Chepeatesthotel_based_on_WeekDay(startdate,enddate);

        Assert.assertEquals("Lakewood",cheapesthotel.getName());
    }

    @Test
    public void ability_to_have_weekday_and_weekend_rates(){
        Assert.assertEquals(90,lakewood.getWeekendrate());
        Assert.assertEquals(50,bridgewood.getWeekendrate());
        Assert.assertEquals(150,ridgewood.getWeekendrate());
    }

    @Test
    public void ability_to_find_cheapest_hotel_based_on_date(){
        LocalDate startdate=LocalDate.of(2020,10,11);
        LocalDate enddate=LocalDate.of(2020,10,12);

        HotelInfo cheapesthotelonWeekDay=hotelReservation.find_Chepeatesthotel_based_on_WeekDay(startdate,enddate);
        HotelInfo cheapesthotelonWeekEnd=hotelReservation.find_Chepeatesthotel_based_on_WeekEnd(startdate,enddate);

        Assert.assertEquals("Lakewood",cheapesthotelonWeekDay.getName());
        Assert.assertEquals("Bridgewood",cheapesthotelonWeekEnd.getName());
    }

    @Test
    public void check_ratings_of_hotels(){
        Assert.assertEquals(3,lakewood.getRating());
        Assert.assertEquals(4,bridgewood.getRating());
        Assert.assertEquals(5,ridgewood.getRating());
    }

    @Test
    public void find_cheapest_best_rated_hotel(){
        Assert.assertEquals("Bridgewood",hotelReservation.find_best_rated_hotel_and_also_cheapest());
    }
}
