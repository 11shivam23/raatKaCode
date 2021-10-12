package com.examly.spring.model;

import javax.persistence.*;

@Entity
@Table(name="cart_product")
public class CartProductModel {

    @Id
    @Column(name="cart_product_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private CartModel cart;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductModel product;

    @Column(name="quantity")
    private int quantity;

    @Column(name="price")
    private String Price;

    public CartProductModel() {
        int quantity=0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CartModel getCart() {
        return cart;
    }

    public void setCart(CartModel cart) {
        this.cart = cart;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
