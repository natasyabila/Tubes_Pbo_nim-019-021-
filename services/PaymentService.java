package services;

import models.Donation;

public class PaymentService {
    public void processDonation(Donation donation) {
        // Implementasi untuk memproses donasi
        System.out.println("Processing donation of " + donation.getAmount() + " from user " + donation.getUserId());
    }
}
