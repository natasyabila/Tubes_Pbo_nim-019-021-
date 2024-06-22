package services;

import models.Book;

import java.util.List;

public class ReportService {
    public void reportLostBook(String userId, Book book) {
        // Implementasi pelaporan buku hilang
        System.out.println("User " + userId + " reported lost book: " + book.getTitle());
    }

    public List<Book> suggestBooksBasedOnRating(List<Book> books) {
        // Implementasi saran buku berdasarkan rating
        books.sort((b1, b2) -> Double.compare(b2.getRating(), b1.getRating()));
        return books;
    }
}
