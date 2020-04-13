package payment.serviceimpl;

import com.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payment.repository.PaymentRepository;
import payment.service.PaymentService;

/**
 * @author: 李昭
 * @Date: 2020/4/2 15:45
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Override
    public Integer create(Payment payment) {
        int i = repository.create(payment);
        return i;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment payment = repository.getPaymentById(id);
        return payment;
    }
}
