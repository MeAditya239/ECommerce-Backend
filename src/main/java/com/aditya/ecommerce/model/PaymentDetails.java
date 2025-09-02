package com.aditya.ecommerce.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PaymentDetails {

    private String paymentMethod;
    private String status;
    private String paymentId;
    private String razorpayPaymentLinkId;
    private String razorpayPaymentLinkReferenceId;
    private String razorpayPaymentLinkStatus;
    private String razorpayPaymentId;
}