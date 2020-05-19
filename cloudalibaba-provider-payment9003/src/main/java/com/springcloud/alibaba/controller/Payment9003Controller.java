package com.springcloud.alibaba.controller;

        import com.springcloud.entities.CommonResult;
        import com.springcloud.entities.Payment;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.UUID;

/**
 * @author: 李昭
 * @Date: 2020/5/19 20:54
 */
@RestController
public class Payment9003Controller {

    @Value("${server.port}")
    private String port;

    private static Map<Long, Payment> map = new HashMap<>();

    static {
        map.put(1L, new Payment(1L, UUID.randomUUID().toString()));
        map.put(2L, new Payment(2L, UUID.randomUUID().toString()));
        map.put(3L, new Payment(3L, UUID.randomUUID().toString()));
    }

    @RequestMapping("/payment/{id}")
    public CommonResult<Payment> paymentCommonResult(@PathVariable("id")Long id) {
        Payment payment = map.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from sql,server port" + port, payment);
        return result;
    }
}
