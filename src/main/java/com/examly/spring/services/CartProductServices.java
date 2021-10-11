package com.examly.spring.services;

import com.examly.spring.model.CartProductModel;
import com.examly.spring.repository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.stereotype.Service;


@Service
public class CartProductServices {
    @Autowired
    private CartProductRepository cartProductRepository;

    public void saveCartProduct(CartProductModel cartProductModel)
    {
        cartProductRepository.save(cartProductModel);
    }
}
