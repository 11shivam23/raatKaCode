package com.examly.spring.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class CartModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cart_id")
    private int cartId;

    @Column(name="quantity")
    private int Quantity;

    @Column(name="price")
    private String price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private UserModel user;

    @OneToMany(mappedBy="cart",cascade = CascadeType.ALL)
    private List<CartProductModel> cartProductModel = new ArrayList<>();

    public CartModel() {
        super();
        this.Quantity = 0;
        this.price = "0";
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCartId() { return cartId; }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public List<CartProductModel> getCartProductModel() {
        return cartProductModel;
    }

    public void setCartProductModel(List<CartProductModel> cartProductModel) {
        this.cartProductModel = cartProductModel;
    }


}