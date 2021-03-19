package com.myPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import static com.myPackage.HotelReservation.hotelInfos;

public class HotelReservatioTest {

    @Test
    public void inserting_Hotel_True_if_inserted(){
        HotelReservation hotelReservation = new HotelReservation(Customertype.Regular_customer);
        HotelInfo lakewood = new HotelInfo( "Lakewood", 110, 90, 0, 0, 0);
        HotelInfo bridgewood = new HotelInfo( "Bridgewood", 150, 50, 0, 0, 0);
        HotelInfo ridgewood = new HotelInfo( "Ridgewood", 220, 150, 0, 0, 0);

        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

        int hotelcount=hotelReservation.Size();
        Assert.assertEquals(3,hotelcount);

        hotelInfos.forEach(System.out::println);
    }

    @Test
    public void ability_to_find_cheapest_hotel(){
        HotelReservation hotelReservation = new HotelReservation(Customertype.Regular_customer);
        HotelInfo lakewood = new HotelInfo( "Lakewood", 110, 90, 0, 0, 0);
        HotelInfo bridgewood = new HotelInfo( "Bridgewood", 150, 50, 0, 0, 0);
        HotelInfo ridgewood = new HotelInfo( "Ridgewood", 220, 150, 0, 0,0);

        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

        LocalDate startdate=LocalDate.of(2020,10,10);
        LocalDate enddate=LocalDate.of(2020,10,11);


        HotelInfo cheapesthotel=hotelReservation.find_Chepeatesthotelint(startdate,enddate);

        Assert.assertEquals("Lakewood",cheapesthotel.getName());
    }

    @Test
    public void ability_to_have_weekday_and_weekend_rates(){
        HotelReservation hotelReservation = new HotelReservation(Customertype.Regular_customer);
        HotelInfo lakewood = new HotelInfo( "Lakewood", 110, 90, 0, 0, 0);
        HotelInfo bridgewood = new HotelInfo( "Bridgewood", 150, 50, 0, 0, 0);
        HotelInfo ridgewood = new HotelInfo( "Ridgewood", 220, 150, 0, 0,0);

        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

        Assert.assertEquals(90,lakewood.getWeekendrate());
        Assert.assertEquals(50,bridgewood.getWeekendrate());
        Assert.assertEquals(150,ridgewood.getWeekendrate());
    }

    @Test
    public void ability_to_find_cheapest_hotel_based_on_date(){
        HotelReservation hotelReservation = new HotelReservation(Customertype.Regular_customer);
        HotelInfo lakewood = new HotelInfo( "Lakewood", 110, 90, 0, 0, 0);
        HotelInfo bridgewood = new HotelInfo( "Bridgewood", 150, 50, 0, 0, 0);
        HotelInfo ridgewood = new HotelInfo( "Ridgewood", 220, 150, 0, 0,0);

        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

        LocalDate startdate=LocalDate.of(2020,10,10);
        LocalDate enddate=LocalDate.of(2020,10,11);

        HotelInfo cheapesthotel=hotelReservation.find_Chepeatesthotelint(startdate,enddate);

        Assert.assertEquals("Lakewood",cheapesthotel.getName());
    }

    @Test
    public void check_ratings_of_hotels(){
        HotelReservation hotelReservation = new HotelReservation(Customertype.Regular_customer);
        HotelInfo lakewood = new HotelInfo( "Lakewood", 110, 90, 3, 0, 0);
        HotelInfo bridgewood = new HotelInfo( "Bridgewood", 150, 50, 4, 0, 0);
        HotelInfo ridgewood = new HotelInfo( "Ridgewood", 220, 150, 5, 0,0);

        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

        Assert.assertEquals(3,lakewood.getRating());
        Assert.assertEquals(4,bridgewood.getRating());
        Assert.assertEquals(5,ridgewood.getRating());
    }

    @Test
    public void find_cheapest_best_rated_hotel(){
        HotelReservation hotelReservation = new HotelReservation(Customertype.Regular_customer);
        HotelInfo lakewood = new HotelInfo( "Lakewood", 110, 90, 3, 0, 0);
        HotelInfo bridgewood = new HotelInfo( "Bridgewood", 150, 50, 4, 0, 0);
        HotelInfo ridgewood = new HotelInfo( "Ridgewood", 220, 150, 5, 0,0);

        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

        LocalDate startdate=LocalDate.of(2020,10,11);
        LocalDate enddate=LocalDate.of(2020,10,12);

        HotelInfo cheapesthotel=hotelReservation.find_Chepeatesthotelint(startdate,enddate);

        Assert.assertEquals("Bridgewood",cheapesthotel.getName());
    }

    @Test
    public void check_best_rated_hotel() throws  ParseException{
        HotelReservation hotelReservation = new HotelReservation(Customertype.Regular_customer);
        HotelInfo lakewood = new HotelInfo( "Lakewood", 110, 90, 3, 0, 0);
        HotelInfo bridgewood = new HotelInfo( "Bridgewood", 150, 50, 4, 0, 0);
        HotelInfo ridgewood = new HotelInfo( "Ridgewood", 220, 150, 5, 0,0);

        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

        LocalDate startdate=LocalDate.of(2020,10,11);
        LocalDate enddate=LocalDate.of(2020,10,12);

        HotelInfo bestrateHotel=hotelReservation.find_best_rated_hotel(startdate,enddate);
        Assert.assertEquals("Ridgewood",bestrateHotel.getName());
    }

    @Test
    public void add_reward_customer() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation(Customertype.Reward_customer);
        HotelInfo lakewood = new HotelInfo( "Lakewood", 110, 90, 3, 80, 80);
        HotelInfo bridgewood = new HotelInfo( "Bridgewood", 150, 50, 4, 110, 50);
        HotelInfo ridgewood = new HotelInfo( "Ridgewood", 220, 150, 5, 100,40);

        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

        Assert.assertEquals(80,lakewood.getWeekdayRewardRate());
    }

    @Test
    public void find_cheap_hotel_for_reward_customer() throws ParseException{
        HotelReservation hotelReservation = new HotelReservation(Customertype.Reward_customer);
        HotelInfo lakewood = new HotelInfo( "Lakewood", 110, 90, 3, 80, 80);
        HotelInfo bridgewood = new HotelInfo( "Bridgewood", 150, 50, 4, 110, 50);
        HotelInfo ridgewood = new HotelInfo( "Ridgewood", 220, 150, 5, 100,40);

        hotelReservation.addhotel(lakewood);
        hotelReservation.addhotel(bridgewood);
        hotelReservation.addhotel(ridgewood);

        LocalDate startdate=LocalDate.of(2020,10,11);
        LocalDate enddate=LocalDate.of(2020,10,12);

        HotelInfo cheaphotelforrewardcustomer=hotelReservation.find_best_rated_hotel(startdate,enddate);
        Assert.assertEquals("Ridgewood",cheaphotelforrewardcustomer.getName());
    }

}
