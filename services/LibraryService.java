package services;

import models.Admin;
import models.Book;
import models.Student;
import models.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {

    private Map<String, LocalDate> borrowedBooks;  // Key: Book ID, Value: Borrow Date
    private Map<String, LocalDate> returnedBooks;  // Key: Book ID, Value: Return Date

    public LibraryService() {
        borrowedBooks = new HashMap<>();
        returnedBooks = new HashMap<>();
    }

    public boolean borrowBook(String studentId, String bookId) {
        if (!borrowedBooks.containsKey(bookId)) {
            borrowedBooks.put(bookId, LocalDate.now());
            return true;
        }
        return false;
    }

    public boolean returnBook(String studentId, String bookId) {
        if (borrowedBooks.containsKey(bookId)) {
            borrowedBooks.remove(bookId);
            returnedBooks.put(bookId, LocalDate.now());
            return true;
        }
        return false;
    }

    public boolean isBookBorrowedByStudent(String studentId, String bookId) {
        return borrowedBooks.containsKey(bookId);
    }

    public LocalDate getReturnDate(String bookId) {
        return returnedBooks.get(bookId);
    }

    public void addBook(Book book) {
    }

    public boolean removeBook(String bookId) {
        return false;
    }

    public List<Object> getBooks() {
        return null;
    }

    public void addUser(Student student) {
    }

    public void addUser(Admin bob) {
    }

    public User getUserById(String userId) {
        return null;
    }
}
