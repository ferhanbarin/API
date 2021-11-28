package API.POJOS;

public class BookingResponsePOJO {

/*
    {
    "bookingid": 11,
    "booking": {
    "firstname": "Selim",
    "lastname": "Ak",
    "totalprice": 15000,
    "depositpaid": true,
    "bookingdates": {
    "checkin": "2020-09-09",
    "checkout": "2020-09-21"
    }
        }
*/

    private int bookingid;
    private BookingPOJO booking;


    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPOJO getBooking() {
        return booking;
    }

    public void setBooking(BookingPOJO booking) {
        this.booking = booking;
    }


    public BookingResponsePOJO() {
    }

    public BookingResponsePOJO(int bookingid, BookingPOJO booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }


    @Override
    public String toString() {

        return "BookingResponsePOJO{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
