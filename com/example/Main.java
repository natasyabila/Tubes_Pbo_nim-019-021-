package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Book;
import models.Student;
import services.LibraryService;
import services.NotificationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main extends Application {

    private LibraryService libraryService;
    private NotificationService notificationService;
    private List<Book> books;

    public Main() {
        libraryService = new LibraryService();
        notificationService = new NotificationService();
        books = new ArrayList<>();
        initializeBooks(); // Initialize some example books
    }

    private void initializeBooks() {
        // Example books
        books.add(new Book("Clean Code", "Robert C. Martin", "00501"));
        books.add(new Book("Design Patterns", "Erich Gamma et al.", "00502"));
        books.add(new Book("Introduction to Algorithms", "Thomas H. Cormen", "00503"));
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library System");

        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        // Set background image
        root.setBackground(new Background(new BackgroundFill(
                Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        Label welcomeLabel = new Label("Perpustakaan Universitas Muhammadiyah Malang");

        // Button for Student
        Button studentButton = new Button("Student");
        studentButton.setOnAction(event -> {
            // Show dialog for entering Student details
            TextInputDialog nameDialog = new TextInputDialog();
            nameDialog.setTitle("Student Information");
            nameDialog.setHeaderText("Enter Student Name");
            nameDialog.setContentText("Name:");
            Optional<String> nameResult = nameDialog.showAndWait();
            if (nameResult.isPresent() && !nameResult.get().trim().isEmpty()) {
                // Show dialog for entering NIM
                TextInputDialog nimDialog = new TextInputDialog();
                nimDialog.setTitle("Student Information");
                nimDialog.setHeaderText("Enter Student NIM");
                nimDialog.setContentText("NIM:");
                Optional<String> nimResult = nimDialog.showAndWait();
                if (nimResult.isPresent() && !nimResult.get().trim().isEmpty() && nimResult.get().trim().length() == 15) {
                    // Show dialog for entering Faculty
                    TextInputDialog facultyDialog = new TextInputDialog();
                    facultyDialog.setTitle("Student Information");
                    facultyDialog.setHeaderText("Enter Student Faculty");
                    facultyDialog.setContentText("Faculty:");
                    Optional<String> facultyResult = facultyDialog.showAndWait();
                    if (facultyResult.isPresent() && !facultyResult.get().trim().isEmpty()) {
                        // Show dialog for entering Program
                        TextInputDialog programDialog = new TextInputDialog();
                        programDialog.setTitle("Student Information");
                        programDialog.setHeaderText("Enter Student Program");
                        programDialog.setContentText("Program:");
                        Optional<String> programResult = programDialog.showAndWait();
                        if (programResult.isPresent() && !programResult.get().trim().isEmpty()) {
                            // Show dialog for entering PIN
                            TextInputDialog pinDialog = new TextInputDialog();
                            pinDialog.setTitle("Student Information");
                            pinDialog.setHeaderText("Enter PIN");
                            pinDialog.setContentText("PIN:");
                            Optional<String> pinResult = pinDialog.showAndWait();
                            if (pinResult.isPresent() && !pinResult.get().trim().isEmpty()) {
                                // Create a Student instance with the entered data
                                Student student = new Student(
                                        nameResult.get().trim(),
                                        nimResult.get().trim(),
                                        facultyResult.get().trim(),
                                        programResult.get().trim(),
                                        pinResult.get().trim()
                                );
                                // Show Student menu
                                displayStudentMenu(primaryStage, student);
                            } else {
                                showAlert("Missing Information", "Student Information Required", "Please fill in all student information before proceeding.");
                            }
                        } else {
                            showAlert("Missing Information", "Student Information Required", "Please fill in all student information before proceeding.");
                        }
                    } else {
                        showAlert("Missing Information", "Student Information Required", "Please fill in all student information before proceeding.");
                    }
                } else {
                    showAlert("Invalid NIM", "NIM Invalid", "NIM should be 15 characters long.");
                }
            } else {
                showAlert("Missing Information", "Student Information Required", "Please fill in all student information before proceeding.");
            }
        });

        // Button for Admin
        Button adminButton = new Button("Admin");
        adminButton.setOnAction(event -> {
            // Show dialog for entering Username
            TextInputDialog usernameDialog = new TextInputDialog();
            usernameDialog.setTitle("Admin Login");
            usernameDialog.setHeaderText("Enter Admin Username");
            usernameDialog.setContentText("Username:");
            usernameDialog.showAndWait().ifPresent(username -> {
                // Show dialog for entering Password
                TextInputDialog passwordDialog = new TextInputDialog();
                passwordDialog.setTitle("Admin Login");
                passwordDialog.setHeaderText("Enter Admin Password");
                passwordDialog.setContentText("Password:");
                passwordDialog.showAndWait().ifPresent(password -> {
                    // Validate admin (simple example)
                    if (username.equals("admin") && password.equals("admin123")) {
                        // Show successful admin access
                        Alert accessAlert = new Alert(Alert.AlertType.INFORMATION);
                        accessAlert.setTitle("Access Success");
                        accessAlert.setHeaderText("Access Granted as Admin");
                        accessAlert.setContentText("Welcome, Admin!");
                        accessAlert.showAndWait();
                        // Show Admin menu
                        displayAdminMenu(primaryStage);
                    } else {
                        // Show error message for failed login
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setTitle("Access Denied");
                        errorAlert.setHeaderText("Login Failed");
                        errorAlert.setContentText("Invalid username or password. Please try again.");
                        errorAlert.showAndWait();
                    }
                });
            });
        });

        root.getChildren().addAll(welcomeLabel, studentButton, adminButton);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Output to console to ensure the program runs
        System.out.println("Application started successfully!");
    }

    private void displayStudentMenu(Stage primaryStage, Student student) {
        VBox studentRoot = new VBox();
        studentRoot.setSpacing(10);
        studentRoot.setAlignment(Pos.CENTER);

        Label studentLabel = new Label("Student Menu");

        // Button for Display Profile
        Button profileButton = new Button("Display Profile");
        profileButton.setOnAction(event -> {
            student.displayProfile();
        });

        // Button for Borrow Book
        Button borrowBookButton = new Button("Borrow Book");
        borrowBookButton.setOnAction(event -> {
            TextInputDialog bookIdDialog = new TextInputDialog();
            bookIdDialog.setTitle("Borrow Book");
            bookIdDialog.setHeaderText("Enter Book ID to Borrow");
            bookIdDialog.setContentText("Book ID:");
            bookIdDialog.showAndWait().ifPresent(bookId -> {
                // Validate ID format (5 digits)
                if (bookId.matches("\\d{5}")) {  // Validate 5 digit number
                    // Check if the book with the given ID exists
                    Optional<Book> bookToBorrow = books.stream().filter(book -> book.getId().equals(bookId)).findFirst();
                    if (bookToBorrow.isPresent()) {
                        boolean success = libraryService.borrowBook(student.getId(), bookId);
                        if (success) {
                            notificationService.sendDueDateReminder(student.getId(), bookId, LocalDate.now().plusDays(2));
                            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                            successAlert.setTitle("Borrow Book");
                            successAlert.setHeaderText("Book Borrowed Successfully");
                            successAlert.setContentText("You have borrowed the book successfully.");
                            successAlert.showAndWait();
                        } else {
                            showAlert("Failed to Borrow Book", "Book Unavailable", "The book could not be borrowed.");
                        }
                    } else {
                        showAlert("Book Not Found", "Book Not Found", "The book with ID " + bookId + " is not available in the library.");
                    }
                } else {
                    showAlert("Invalid Book ID", "Invalid ID Format", "Book ID should be exactly 5 digits.");
                }
            });
        });

        // Button for Return Book
        Button returnBookButton = new Button("Return Book");
        returnBookButton.setOnAction(event -> {
            TextInputDialog bookIdDialog = new TextInputDialog();
            bookIdDialog.setTitle("Return Book");
            bookIdDialog.setHeaderText("Enter Book ID to Return");
            bookIdDialog.setContentText("Book ID:");
            bookIdDialog.showAndWait().ifPresent(bookId -> {
                // Validate ID format (5 digits)
                if (bookId.matches("\\d{5}")) {  // Validate 5 digit number
                    // Check if the book with the given ID exists
                    Optional<Book> bookToReturn = books.stream().filter(book -> book.getId().equals(bookId)).findFirst();
                    if (bookToReturn.isPresent()) {
                        // Check if the book is borrowed by the student
                        if (libraryService.isBookBorrowedByStudent(student.getId(), bookId)) {
                            boolean success = libraryService.returnBook(student.getId(), bookId);
                            if (success) {
                                LocalDate returnDate = libraryService.getReturnDate(bookId);
                                if (returnDate.equals(LocalDate.now())) {
                                    notificationService.sendReturnNotification(student.getId(), bookId, returnDate);
                                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                                    successAlert.setTitle("Return Book");
                                    successAlert.setHeaderText("Book Returned Successfully");
                                    successAlert.setContentText("You have returned the book successfully. The return notification has been sent.");
                                    successAlert.showAndWait();
                                } else {
                                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                                    successAlert.setTitle("Return Book");
                                    successAlert.setHeaderText("Book Returned Successfully");
                                    successAlert.setContentText("You have returned the book successfully.");
                                    successAlert.showAndWait();
                                }
                            } else {
                                showAlert("Failed to Return Book", "Return Failed", "The book could not be returned.");
                            }
                        } else {
                            showAlert("Book Not Borrowed", "Return Failed", "You have not borrowed the book with ID " + bookId + ".");
                        }
                    } else {
                        showAlert("Book Not Found", "Book Not Found", "The book with ID " + bookId + " is not available in the library.");
                    }
                } else {
                    showAlert("Invalid Book ID", "Invalid ID Format", "Book ID should be exactly 5 digits.");
                }
            });
        });

        // Button for Log Out
        Button logoutButton = new Button("Log Out");
        logoutButton.setOnAction(event -> {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Log Out");
            confirmationAlert.setHeaderText("Confirm Log Out");
            confirmationAlert.setContentText("Are you sure you want to log out?");
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                start(primaryStage); // Return to the main menu
            }
        });

        studentRoot.getChildren().addAll(studentLabel, profileButton, borrowBookButton, returnBookButton, logoutButton);
        Scene studentScene = new Scene(studentRoot, 300, 300);
        primaryStage.setScene(studentScene);
        primaryStage.show();
    }

    private void displayAdminMenu(Stage primaryStage) {
        VBox adminRoot = new VBox();
        adminRoot.setSpacing(10);
        adminRoot.setAlignment(Pos.CENTER);

        Label adminLabel = new Label("Admin Menu");

        // Pada displayAdminMenu method
        Button addBookButton = new Button("Add Book");
        addBookButton.setOnAction(event -> {
            TextInputDialog titleDialog = new TextInputDialog();
            titleDialog.setTitle("Add Book");
            titleDialog.setHeaderText("Enter Book Title");
            titleDialog.setContentText("Title:");
            titleDialog.showAndWait().ifPresent(title -> {
                TextInputDialog authorDialog = new TextInputDialog();
                authorDialog.setTitle("Add Book");
                authorDialog.setHeaderText("Enter Book Author");
                authorDialog.setContentText("Author:");
                authorDialog.showAndWait().ifPresent(author -> {
                    TextInputDialog idDialog = new TextInputDialog();
                    idDialog.setTitle("Add Book");
                    idDialog.setHeaderText("Enter Book ID (5 digits)");
                    idDialog.setContentText("ID:");
                    idDialog.showAndWait().ifPresent(id -> {
                        // Validate ID format (5 digits)
                        if (id.matches("\\d{5}")) {  // Validate 5 digit number
                            Book book = new Book(title, author, id);
                            books.add(book);
                            displayBooks(); // Display updated list of books after adding a new book
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Book Added");
                            alert.setHeaderText("Book Added Successfully");
                            alert.setContentText("Book has been added to the library.");
                            alert.showAndWait();
                        } else {
                            showAlert("Invalid ID", "Invalid ID Format", "Book ID should be exactly 5 digits.");
                        }
                    });
                });
            });
        });

        // Button for Display Books
        Button displayBooksButton = new Button("Display Books");
        displayBooksButton.setOnAction(event -> displayBooks());

        // Button for Back to Main Menu
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            start(primaryStage); // Return to the main menu
        });

        adminRoot.getChildren().addAll(adminLabel, addBookButton, displayBooksButton, backButton);

        Scene adminScene = new Scene(adminRoot, 300, 250);
        primaryStage.setScene(adminScene);
        primaryStage.show();
    }

    private void displayBooks() {
        try {
            if (books.isEmpty()) {
                showAlert("No Books", "No Books Available", "There are currently no books in the library.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Books in Library:\n\n");

            for (Book book : books) {
                // Check if ID is 5 digits
                if (book.getId().matches("\\d{5}")) {
                    sb.append("Judul Buku: ").append(book.getTitle()).append("\n");
                    sb.append("Pengarang: ").append(book.getAuthor()).append("\n");
                    sb.append("ID Buku: ").append(book.getId()).append("\n\n");
                }
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Books in Library");
            alert.setHeaderText(null);
            alert.setContentText(sb.toString());
            alert.showAndWait();
        } catch (Exception e) {
            showAlert("Error", "Error displaying books", "An error occurred while displaying the books: " + e.getMessage());
        }
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
