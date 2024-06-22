package models;

import java.util.Collection;
import java.util.Scanner;

public class Student extends User {
    private String name;
    private String nim;
    private String faculty;
    private String program;
    private String pin;

    public Student(String name, String nim, String faculty, String program, String pin) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
        this.pin = pin;
    }

    public static void displayMenu(Student student) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("===== Menu Student =====");
            System.out.println("1. Display Profile");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    student.displayProfile();
                    break;
                case 2:
                    Book book = null;
                    student.borrowBook(book);
                    break;
                case 3:
                    student.returnBook();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }

        scanner.close();
    }

    public void displayProfile() {
        // Implementasi untuk menampilkan profil student
        System.out.println("===== Displaying Profile =====");
        System.out.println("Name: " + this.name);
        System.out.println("NIM: " + this.nim);
        System.out.println("Faculty: " + this.faculty);
        System.out.println("Program: " + this.program);
        System.out.println("PIN: " + this.pin);
    }

    public void borrowBook(Book book) {
        // Implementasi untuk meminjam buku
        System.out.println("===== Borrowing a Book =====");
        // Tambahkan kode untuk proses peminjaman buku
    }

    public void returnBook() {
        // Implementasi untuk mengembalikan buku
        System.out.println("===== Returning a Book =====");
        // Tambahkan kode untuk proses pengembalian buku
    }

    @Override
    public boolean canBorrowBooks() {
        return false;
    }

    @Override
    public Object getPin() {
        return this.pin;
    }

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

    public void returnBook(Book book) {
    }
}
