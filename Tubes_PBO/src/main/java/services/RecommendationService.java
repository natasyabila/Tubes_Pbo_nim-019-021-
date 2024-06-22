package services;

import models.Book;
import models.BookRating;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecommendationService {
    private List<BookRating> ratings;

    public RecommendationService() {
        this.ratings = new ArrayList<>();
    }

    public void addRating(BookRating rating) {
        ratings.add(rating);
    }

    public List<Book> recommendBooks(List<Book> books) {
        // Urutkan buku berdasarkan rating dan kembalikan rekomendasi
        books.sort(Comparator.comparingInt(book -> {
            int rating = (int) ratings.stream()
                    .filter(r -> r.getBookId().equals(book.getId()))
                    .mapToInt(BookRating::getRating)
                    .average().orElse(0);
            return -rating; // Descending order
        }));
        return books;
    }
}
