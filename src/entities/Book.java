package entities;

public class Book {
    private int id;
    private String title;
    private int year;
    private String author;
    private String notes;
    private String  publisher;
    private String category;



    public Book(int id, String title, int year, String author, String notes, String publisher,String category){
        this.id = id;
        this.title = title;
        this.year = year;
        this.author = author;
        this.notes = notes;
        this.publisher = publisher;
        this.category = category;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + year + " " + author + " " + notes + " " + publisher + " " + category ;
    }

}


