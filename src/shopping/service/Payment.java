package shopping.service;

import shopping.model.PaymentMethod;

public interface Payment {
    boolean pay(double amount, PaymentMethod method);
}
