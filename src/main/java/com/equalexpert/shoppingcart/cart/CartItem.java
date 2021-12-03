package com.equalexpert.shoppingcart.cart;

import com.equalexpert.shoppingcart.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * All shop carts consists cart items
 * all cart items needs product detail and amount
 */
@Data
@AllArgsConstructor
public class CartItem {

    private Product product;
    private Integer amount;


}
