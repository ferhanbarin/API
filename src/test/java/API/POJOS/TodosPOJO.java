package API.POJOS;

public class TodosPOJO {

/*
    {
    "userId": 21,
    "id": 201,
    "title": "Tidy your room",
    "completed": false
    }
*/

    // 1- Degiskenleri "private" yapiyoruz.
    private int userId;
    private int id;
    private String title;
    private boolean completed;


    // 2- Bu degerlere ulasabilmek icin public getter ve setter method'lar olusturalim.
    public int getUserId() {

        return userId;
    }


    public void setUserId (int userId) {

        this.userId = userId;
    }


    public int getId() {

        return id;
    }


    public void setId (int id) {

        this.id = id;
    }


    public String getTitle() {

        return title;
    }


    public void setTitle (String title) {

        this.title = title;
    }


    public boolean isCompleted() {

        return completed;
    }


    public void setCompleted (boolean completed) {

        this.completed = completed;
    }


    // 3- Parametreli ve parametresiz constructor olusturuyoruz.
    public TodosPOJO() {

    }


    public TodosPOJO(int userId, int id, String title, boolean completed) {

        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }


    // 4- toString method'u olusturuyoruz.
    @Override
    public String toString() {
        return "TodosPOJO{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
