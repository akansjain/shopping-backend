package org.example.service;

import org.example.model.Cart;
import org.example.model.Product;
import org.example.repository.CartRepository;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart addProductToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found!"));

        Cart cart = new Cart(product, quantity);
        return cartRepository.save(cart);
    }


    public List<Product> getCartItems() {
            List<Cart> cartItems = cartRepository.findAll();

        System.out.println("_________________"+cartItems.stream()
                .map(Cart::getProduct) // Assuming Cart has a getProduct method
                .collect(Collectors.toList()));
        // Map cart items to products
        return cartItems.stream()
                .map(Cart::getProduct) // Assuming Cart has a getProduct method
                .collect(Collectors.toList());
//        return new ArrayList<>();
    }
}

