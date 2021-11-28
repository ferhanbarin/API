package API.POJOS;

public class BookingDatesPOJO {

/*
    "checkin": "2020-09-09",
    "checkout": "2020-09-21"
*/

    // 1- Private degiskenler olusturduk.
    private String checkin;
    private String checkout;



    // 2- Getter & Setter
    public String getCheckin() {
        return checkin;
    }


    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }


    public String getCheckout() {
        return checkout;
    }


    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }



    // 3- Parametreli ve parametresiz constructor olustur.
    public BookingDatesPOJO() {
    }


    public BookingDatesPOJO(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }



    // 4- toString method'u olustur.
    @Override
    public String toString() {
        return "BookingDatesPOJO{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
