package models;

public class BookRating {
    private String bookId;
    private int rating;

    public BookRating(String bookId, int rating) {
        this.bookId = bookId;
        this.rating = rating;
    }

    public String getBookId() {
        return bookId;
    }

    public int getRating() {
        return rating;
    }
}
