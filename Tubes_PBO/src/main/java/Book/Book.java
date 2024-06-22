package Book;

import java.util.UUID;

public class Book {
    private String id;
    private final String issn;
    private final String ddc;
    private String title;
    private boolean isAvailable;
    private double rating;

    public Book(String title, String ddc) {
        this.id = UUID.randomUUID().toString();
        this.issn = generateISSN();
        this.ddc = ddc;
        this.title = title;
        this.isAvailable = true;
        this.rating = 0.0;
    }

    private String generateISSN() {
        return "ISSN-" + (int)(Math.random() * 1000000);
    }

    public String getId() {
        return id;
    }

    public String getIssn() {
        return issn;
    }

    public String getDdc() {
        return ddc;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
