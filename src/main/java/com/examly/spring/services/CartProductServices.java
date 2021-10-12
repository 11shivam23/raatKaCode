package com.examly.spring.services;

import com.examly.spring.model.CartModel;
import com.examly.spring.model.CartProductModel;
import com.examly.spring.model.ProductModel;
import com.examly.spring.repository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartProductServices {
    @Autowired
    private CartProductRepository cartProductRepository;

    public void saveCartProduct(CartProductModel cartProductModel)
    {
        cartProductRepository.save(cartProductModel);
    }



    public CartProductModel findByProductCart(ProductModel product, CartModel cart) {
        CartProductModel cartProductModel = cartProductRepository.findByProductAndCart(product,cart);
        return cartProductModel;
    }

    public boolean existsProductCart(ProductModel product, CartModel cart){
        return cartProductRepository.existsByProductAndCart(product,cart);
    }

    public boolean existsCart(CartModel cart) {
        return cartProductRepository.existsByCart(cart);
    }

    public boolean findCartProduct(ProductModel product, CartModel cart) {
        return cartProductRepository.findByCartAndProduct(product,cart);
    }

//    public List<CartProductModel> findByCartId(int cartId) {
//        return cartProductRepository.findByCartId(cartId);
//    }


}
