package com.aditya.ecommerce.controller;


import com.aditya.ecommerce.exception.OrderException;
import com.aditya.ecommerce.model.Order;
import com.aditya.ecommerce.repository.OrderRepository;
import com.aditya.ecommerce.response.ApiResponse;
import com.aditya.ecommerce.service.OrderService;
import com.aditya.ecommerce.service.UserService;
import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import netscape.javascript.JSException;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Value("${razorpay.api.key}")
    String apiKey;

    @Value("${razorpay.api.secret}")
    String apiSecret;


    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/payments/{orderId}")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(@PathVariable Long orderId) throws OrderException, RazorpayException {
        Order order = orderService.findOrderById(orderId);

        if(order.getUser() == null) {
            throw new OrderException("User not associated with this order!");
        }

        RazorpayClient razorpay = new RazorpayClient(apiKey, apiSecret);
        JSONObject paymentLinkRequest = new JSONObject();

        paymentLinkRequest.put("amount", order.getTotalPrice() * 100);
        paymentLinkRequest.put("currency", "INR");

        JSONObject customer = new JSONObject();
        customer.put("name", order.getUser().getFirstName());
        customer.put("email", order.getUser().getEmail());
        paymentLinkRequest.put("customer", customer);

        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);

        paymentLinkRequest.put("callback_url", "http://localhost:3000/payment/" + orderId);

        PaymentLink paymentLink = razorpay.paymentLink.create(paymentLinkRequest);

        PaymentLinkResponse res = new PaymentLinkResponse();
        res.setPayment_link_id(paymentLink.get("id"));
        res.setPayment_link_url(paymentLink.get("short_url"));

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    @GetMapping("/payments")
    public ResponseEntity<ApiResponse> redirect(@RequestParam(name = "payment_id") String paymentId, @RequestParam(name = "order_id") Long orderId) throws OrderException, RazorpayException {
        Order order = orderService.findOrderById(orderId);

        RazorpayClient razorpay = new RazorpayClient(apiKey, apiSecret);

        try {
            Payment payment = razorpay.payments.fetch(paymentId);

            if (payment.get("status").equals("captured")) {
                order.getPaymentDetails().setPaymentId(paymentId);
                order.getPaymentDetails().setStatus("Completed");
                order.setOrderStatus("PLACED");

                orderRepository.save(order);
            }

            ApiResponse res = new ApiResponse();
            res.setMessage("your order get placed");
            res.setStatus(true);

            return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);


        }catch(Exception e) {
            throw new RazorpayException(e.getMessage());

        }
    }
}
