package API.POJOS;

public class BookingPOJO {

/*
    "booking": {
    "firstname": "Selim",
    "lastname": "Ak",
    "totalprice": 15000,
    "depositpaid": true,
    "bookingdates": {
    "checkin": "2020-09-09",
    "checkout": "2020-09-21"
    }
*/

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpad;
    private BookingDatesPOJO bookingdates; // Daha önce olusturdugum POJO kalibini DataType olarak belirterek yeni POJO'nun icerisine gömmüs oldum.


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpad() {
        return depositpad;
    }

    public void setDepositpad(boolean depositpad) {
        this.depositpad = depositpad;
    }

    public BookingDatesPOJO getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatesPOJO bookingdates) {
        this.bookingdates = bookingdates;
    }


    public BookingPOJO() {
    }

    public BookingPOJO(String firstname, String lastname, int totalprice, boolean depositpad, BookingDatesPOJO bookingdates) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpad = depositpad;
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {

        return "BookingPOJO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpad=" + depositpad +
                ", bookingdates=" + bookingdates +
                '}';
    }
}
