package models;

public class Book {
    private String title;
    private String author;
    private String id;

    public Book(String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return false;
    }

    public void setAvailable(boolean b) {
    }

    public double getRating() {
        return 0;
    }
}
