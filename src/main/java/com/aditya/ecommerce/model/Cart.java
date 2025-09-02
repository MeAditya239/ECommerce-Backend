package com.aditya.ecommerce.model;
import java.util.HashSet;
import java.util.Set;
import com.aditya.ecommerce.model.CartItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
    @Column(name = "cart_item")
    private Set<CartItem>cartItem = new HashSet<>();

    @Column(name = "total_price")
    private double totalprice;

    @Column(name = "total_Item")
    private int TotalItem;

    private int totalDiscountedPrice;

    private int discount;



    public Cart() {
        // TODO Auto-generated constructor stub
    }



    public Cart(Long id, User user, Set<CartItem> cartItem, double totalprice, int totalItem, int totalDiscountedPrice,
                int discount) {
        super();
        this.id = id;
        this.user = user;
        this.cartItem = cartItem;
        this.totalprice = totalprice;
        this.TotalItem = totalItem;
        this.totalDiscountedPrice = totalDiscountedPrice;
        this.discount = discount;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Set<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public double getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getTotalItem() {
        return TotalItem;
    }

    public void setTotalItem(int totalItem) {
        TotalItem = totalItem;
    }

    public int getTotalDiscountedPrice() {
        return totalDiscountedPrice;
    }

    public void setTotalDiscountedPrice(int totalDiscountedPrice) {
        this.totalDiscountedPrice = totalDiscountedPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
