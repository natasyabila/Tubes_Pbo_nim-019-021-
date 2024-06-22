package controllers;

import models.Admin;
import models.Student;
import models.User;
import services.LibraryService;
import services.NotificationService;

import java.time.LocalDate;

public class LibraryController {
    private LibraryService libraryService;
    private final NotificationService notificationService;

    public LibraryController() {
        this.libraryService = new LibraryService();
        this.notificationService = new NotificationService();

        // Contoh pengisian data pengguna
        libraryService.addUser(new Student("John Doe", "123456", "Engineering", "1", "Alice"));
        libraryService.addUser(new Admin("2", "bob"));
    }

    public LibraryService getLibraryService() {
        return libraryService;
    }

    public void borrowBook(String userId, String bookId) {
        User user = libraryService.getUserById(userId);
        if (user instanceof Student) {
            boolean success = libraryService.borrowBook(userId, bookId);
            if (success) {
                notificationService.sendDueDateReminder(userId, bookId, LocalDate.now().plusDays(2));
                System.out.println("Book borrowed successfully by student!");
            } else {
                System.out.println("Failed to borrow book by student.");
            }
        } else {
            System.out.println("Only students can borrow books.");
        }
    }

    public void returnBook(String userId, String bookId) {
        User user = libraryService.getUserById(userId);
        if (user instanceof Admin) {
            boolean success = libraryService.returnBook(userId, bookId);
            if (success) {
                System.out.println("Book returned successfully by admin!");
            } else {
                System.out.println("Failed to return book by admin.");
            }
        } else {
            System.out.println("Unauthorized user.");
        }
    }

    public void returnBook(String number, Class<?> aClass) {
    }

    public void borrowBook(String number, Class<?> aClass) {
    }
}

