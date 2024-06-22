package services;

import java.time.LocalDate;

public class NotificationService {
    public void notifyLateReturn(String userId, String bookId) {
        // Implementasi logika notifikasi (misalnya, email, SMS)
        System.out.println("User " + userId + " is late returning book " + bookId);
    }

    public void sendDueDateReminder(String userId, String bookId, LocalDate dueDate) {
        // Implementasi logika notifikasi pengingat jatuh tempo
        System.out.println("Reminder: User " + userId + ", book " + bookId + " is due on " + dueDate);
    }

    public void sendReturnNotification(String id, String bookId, LocalDate returnDate) {
    }
}
