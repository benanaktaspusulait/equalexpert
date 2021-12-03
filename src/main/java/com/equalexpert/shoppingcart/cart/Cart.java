package com.equalexpert.shoppingcart.cart;

import com.equalexpert.shoppingcart.product.Product;
import com.equalexpert.shoppingcart.user.User;
import com.equalexpert.shoppingcart.util.PriceUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * shopping cart model for storing cartitems and total Price and total Amount
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cart {

    private User user;
    private List<CartItem> cartItemList = new ArrayList<>();
    private BigDecimal totalPriceWithTax;
    private BigDecimal totalPrice;
    private BigDecimal totalTaxAmount;

    /**
     *
     */
    public void addItem(Product product, Integer quantity) {

        // try to find if exists in the cart before
        Optional<CartItem> optionalCartItem =
                            cartItemList.stream().
                                    filter(cartItem -> cartItem.getProduct().equals(product)).findAny();
        if(optionalCartItem.isEmpty()){ // this means there is no. so add a new one
            cartItemList.add(new CartItem(product, quantity));
        }else { // this means it has added before. so we need to increase
            CartItem cartItem = optionalCartItem.get();
            cartItem.setAmount(cartItem.getAmount() + quantity);
        }
        // we need to update price and tax
        calculateAndSetTotalPrice();
    }

    /**
     * used streams to calculate faster and easier
     */
    private void calculateAndSetTotalPrice() {

        totalPrice = cartItemList
                 .stream()
                 .map(PriceUtil::getTotalCartItemPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        totalTaxAmount = cartItemList
                .stream()
                .map(PriceUtil::getTotalCartItemTax)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        totalPriceWithTax = cartItemList
                .stream()
                .map(PriceUtil::getTotalCartItemPriceWithTax)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        setTotalTaxAmount(PriceUtil.round(this.totalTaxAmount));
        setTotalPrice(PriceUtil.round(totalPrice));
        setTotalPriceWithTax(PriceUtil.round(totalPriceWithTax));
    }
}
