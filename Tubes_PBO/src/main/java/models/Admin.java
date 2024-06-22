package models;

import services.LibraryService;

import java.util.Collection;

public class Admin extends User {
    public Admin(String id, String name) {
        super(id, name, "Admin"); // Mengatur peran sebagai "Admin"
    }

    @Override
    public boolean canBorrowBooks() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public Object getPin() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Collection<Object> getBooksBorrowed() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Collection<Object> getNim() {
        return null;
    }

    public void addBook(Book book, LibraryService libraryService) {
        libraryService.addBook(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(String bookId, LibraryService libraryService) {
        boolean success = libraryService.removeBook(bookId);
        if (success) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Failed to remove book.");
        }
    }

    // Metode atau logika tambahan untuk admin lainnya
}
