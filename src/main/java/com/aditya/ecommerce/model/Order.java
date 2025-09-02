package com.aditya.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "order_id")
    private String OrderId;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItem = new ArrayList<>();


    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;


    @OneToOne
    private Address shipingAddress;

    @Embedded
    private PaymentDetails paymentDetails = new PaymentDetails();


    private double totalPrice;

    private Integer totalDiscountedPrice;

    private Integer discount;

    private String orderStatus;

    private int totalItem;

    private LocalDateTime createdAt;


    public Order() {
        // TODO Auto-generated constructor stub
    }


    public Order(long id, String orderId, User user, List<OrderItem> orderItem, LocalDateTime orderDate,
                 LocalDateTime deliveryDate, Address shipingAddress, PaymentDetails paymentDetails, double totalPrice,
                 Integer totalDiscountedPrice, Integer discount, String orderStatus, int totalItem,
                 LocalDateTime createdAt) {
        super();
        this.id = id;
        this.OrderId = orderId;
        this.user = user;
        this.orderItem = orderItem;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.shipingAddress = shipingAddress;
        this.paymentDetails = paymentDetails;
        this.totalPrice = totalPrice;
        this.totalDiscountedPrice = totalDiscountedPrice;
        this.discount = discount;
        this.orderStatus = orderStatus;
        this.totalItem = totalItem;
        this.createdAt = createdAt;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getOrderId() {
        return OrderId;
    }


    public void setOrderId(String orderId) {
        OrderId = orderId;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public List<OrderItem> getOrderItem() {
        return orderItem;
    }


    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }


    public LocalDateTime getOrderDate() {
        return orderDate;
    }


    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }


    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }


    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    public Address getShipingAddress() {
        return shipingAddress;
    }


    public void setShipingAddress(Address shipingAddress) {
        this.shipingAddress = shipingAddress;
    }


    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }


    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }


    public double getTotalPrice() {
        return totalPrice;
    }


    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Integer getTotalDiscountedPrice() {
        return totalDiscountedPrice;
    }


    public void setTotalDiscountedPrice(Integer totalDiscountedPrice) {
        this.totalDiscountedPrice = totalDiscountedPrice;
    }


    public Integer getDiscount() {
        return discount;
    }


    public void setDiscount(Integer discount) {
        this.discount = discount;
    }


    public String getOrderStatus() {
        return orderStatus;
    }


    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public int getTotalItem() {
        return totalItem;
    }


    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
