package com.equalexpert.shoppingcart.util;

import com.equalexpert.shoppingcart.cart.CartItem;
import com.equalexpert.shoppingcart.product.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.equalexpert.shoppingcart.constant.Constants.HUNDRED;
import static com.equalexpert.shoppingcart.constant.Constants.PRECISION;

public class PriceUtil {

    public static BigDecimal round(BigDecimal amount) {
        return amount.setScale(PRECISION, RoundingMode.HALF_UP);
    }

    public static BigDecimal getPriceWithTax(Product product) {

        BigDecimal taxAmount = getTaxAmountOnUnitPrice(product);
        BigDecimal priceWithTax = product.getPrice().getValue().add(taxAmount);
        return priceWithTax.setScale(PRECISION, RoundingMode.HALF_UP);
    }

    public static BigDecimal getTaxAmountOnUnitPrice(Product product) {

        BigDecimal taxPercentage = product.getTax().getRate();
        return product.getPrice().getValue().multiply(taxPercentage).divide(HUNDRED).setScale(PRECISION, RoundingMode.HALF_UP);
    }

    /**
     * to be able to get directly totalCartItemPrice
     *
     */
    public static BigDecimal getTotalCartItemPrice(CartItem cartItem) {
        return cartItem.getProduct().getPrice() == null ? BigDecimal.ZERO :
                cartItem.getProduct().getPrice().getValue().multiply(new BigDecimal(cartItem.getAmount()));
    }

    /**
     * to be able to get directly totalCartItemTax
     *
     */
    public static BigDecimal getTotalCartItemTax(CartItem cartItem) {
        return cartItem.getProduct().getPrice() == null ? BigDecimal.ZERO :
                getTaxAmountOnUnitPrice(cartItem.getProduct()).multiply(new BigDecimal(cartItem.getAmount()));
    }

    /**
     * to be able to get directly totalCartItemTax
     *
     */
    public static BigDecimal getTotalCartItemPriceWithTax(CartItem cartItem) {
        return cartItem.getProduct().getPrice() == null ? BigDecimal.ZERO :
                getPriceWithTax(cartItem.getProduct()).multiply(new BigDecimal(cartItem.getAmount()));
    }
}
