package com.examly.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class CartModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cart_id")
    private String cartItemId;

    @ManyToMany
    @JoinTable(
            name = "CART_PRODUCTS",
            joinColumns = @JoinColumn(name="cart_id", referencedColumnName = "cart_id"),
            inverseJoinColumns = @JoinColumn(name="product_id", referencedColumnName = "product_id")
    )
    private List<ProductModel> products;
    
    @Column(name="product_name")
    private String productName;

    @Column(name="quantity")
    private int Quantity;

    @Column(name="price")
    private String price;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",referencedColumnName="user_id")
    private UserModel user;

    public CartModel() {

    }

    public CartModel(
            String cartItemId,
            List<ProductModel> products,
            int quantity,
            String price
            ) {
        super();

        this.cartItemId=cartItemId;
        this.products = products;
        this.Quantity = quantity;
        this.price = price;
    }


    public UserModel getUser() {
        return user;
    }



    public void setUser(UserModel user) {
        this.user = user;
    }



    public List<ProductModel> getProductName() {
        return products;
    }



    public void setProductName(List<ProductModel> products) {
        this.products = products;
    }



    public int getQuantity() {
        return Quantity;
    }



    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }



    public String getPrice() {
        return price;
    }



    public void setPrice(String price) {
        this.price = price;
    }


}