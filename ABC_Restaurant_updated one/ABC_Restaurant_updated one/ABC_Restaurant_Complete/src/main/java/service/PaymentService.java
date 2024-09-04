
package service;

import model.Payment;
import repository.PaymentRepository;

import java.sql.SQLException;
import java.util.List;

public class PaymentService {
    private PaymentRepository paymentRepository = new PaymentRepository();

    public List<Payment> getAllPayments() throws SQLException {
        return paymentRepository.getAllPayments();
    }

    public void savePayment(Payment payment) throws SQLException {
        paymentRepository.savePayment(payment);
    }
}
