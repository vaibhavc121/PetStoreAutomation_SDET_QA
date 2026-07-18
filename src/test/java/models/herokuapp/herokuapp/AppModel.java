package models.herokuapp.herokuapp;

public class AppModel
{
    public static class AuthModel
    {
        public String username;
        public String password;
    }

    public static class HerokuappModel
    {
        public String firstname;
        public String lastname;
        public int totalprice;
        public boolean depositpaid;
        public BookingDates bookingdates;
        public String additionalneeds;

        public static class BookingDates
        {
            public String checkin;
            public String checkout;
        }
    }

    public static class PartialUpdateBookingModel
    {
        public String firstname;
        public String lastname;
    }
}