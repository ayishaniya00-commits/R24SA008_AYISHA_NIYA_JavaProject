package shopping.service;

import shopping.model.PaymentMethod;

public class PaymentProcessor implements Payment {
    private static int successfulPayments = 0;

    @Override
    public boolean pay(double amount, PaymentMethod method) {
        if (amount <= 0) {
            return false;
        }

        switch (method) {
            case CASH_ON_DELIVERY:
                System.out.printf("Payment selected: Cash on Delivery. Amount: ₹%.2f%n", amount);
                break;
            case UPI:
                System.out.printf("UPI payment accepted for ₹%.2f.%n", amount);
                break;
            case CARD:
                System.out.printf("Card payment accepted for ₹%.2f.%n", amount);
                break;
            default:
                return false;
        }

        successfulPayments++;
        return true;
    }

    public static int getSuccessfulPayments() {
        return successfulPayments;
    }
}
