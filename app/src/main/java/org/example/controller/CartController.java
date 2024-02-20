package org.example.controller;

import org.example.model.Cart;
import org.example.model.CartRequest;
import org.example.model.Product;
import org.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Product> getAllItems() {
        return cartService.getCartItems();
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addProductToCart(@RequestBody CartRequest cartRequest) {
        Cart cartItem = cartService.addProductToCart(cartRequest.getProductId(), cartRequest.getQuantity());
        return new ResponseEntity<>(cartItem, HttpStatus.CREATED);
    }

}

