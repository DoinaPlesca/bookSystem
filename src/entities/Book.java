package entities;

public class Book {
    private int id;
    private String author;
    private String title;
    private int year;
    private int rating;
    private String note;


    public Book(int id, String title,String author, int year, int rating, String note){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.rating = rating;
        this.note = note;
    }

    public int getId() {
        return id;}

    public void setId(int id) {
        this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    @Override
    public String toString() {
        return id + " " + title + " " + author + " " + year + " " + rating + " " + note;
    }

}


