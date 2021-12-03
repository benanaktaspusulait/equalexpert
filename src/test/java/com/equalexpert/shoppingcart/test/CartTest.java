package com.equalexpert.shoppingcart.test;

import com.equalexpert.shoppingcart.brand.Brand;
import com.equalexpert.shoppingcart.cart.Cart;
import com.equalexpert.shoppingcart.product.Product;
import com.equalexpert.shoppingcart.price.Price;
import com.equalexpert.shoppingcart.price.Tax;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.equalexpert.shoppingcart.constant.Constants.*;
import static com.equalexpert.shoppingcart.price.TaxType.SALES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CartTest {

    Product soapDove;
    Product axeDeodorant;
    Tax tax;
    Price dovePrice;
    Price axePrice;

    @BeforeEach
    void setup() {

        tax = new Tax(SALES, SALES_TAX_PERCENTAGE);
        dovePrice = new Price(DOVE_PRICE);
        axePrice = new Price(AXE_PRICE);

        soapDove = new Product(new Brand(DOVE_SOAP_NAME), dovePrice, tax);
        axeDeodorant = new Product(new Brand(AXE_DEO_NAME), axePrice, tax);

    }

    @Test
    @DisplayName("5 Dove Soaps each with a unit price of 39.99,  the shopping cart’s total price should equal 199.95")
    void shouldFiveDoveSoapPriceEqualGivenTotalPrice() {

        BigDecimal expectedTotalCartPrice = new BigDecimal("199.95");

        Cart cart = new Cart();
        cart.addItem(soapDove, FIVE_QUANTITY);
        assertThat(cart.getTotalPrice(), is(expectedTotalCartPrice));
    }


    @Test
    @DisplayName("Should assert shopping cart with 5 dove soaps equal given total price")
    void shouldAddFiveDoveSoapProductsToACart() {

        BigDecimal expectedTotalCartPrice = new BigDecimal("224.95");

        Cart cart = new Cart();
        cart.addItem(soapDove, FIVE_QUANTITY);
        assertThat(cart.getTotalPriceWithTax(), is(expectedTotalCartPrice));
    }

    @Test
    @DisplayName("The shopping cart should contain 8 Dove Soaps each with a unit price of 39.99 and the shopping cart’s total price should equal 319.92")
    void shouldEightDoveEqualGivenTotalPrice() {

        Cart cart = new Cart();
        cart.addItem(soapDove, EIGHT_QUANTITY);
        BigDecimal expectedTotalCartPrice = new BigDecimal("319.92");
        assertThat(cart.getTotalPrice(), is(expectedTotalCartPrice));
    }


    @Test
    @DisplayName("Should assert two shopping cart with 8 dove soaps with same unit price and same total cart price")
    void shouldEightDoveEqualGivenTotalPriceWithTax() {

        Cart cart = new Cart();
        BigDecimal expectedTotalCartPrice = new BigDecimal("359.92");
        cart.addItem(soapDove, FIVE_QUANTITY);
        cart.addItem(soapDove, THREE_QUANTITY);
        assertThat(cart.getTotalPriceWithTax(), is(expectedTotalCartPrice));
    }

    @Test
    @DisplayName("The user adds 2 Dove Soaps to the shopping cart, and then adds 2 Axe Deos to the shopping cart. " +
                            "The shopping cart’s total price should equal 314.96.the total sales tax amount for the shopping cart should equal 35.00")
    void shouldAddTwoDoveSoapsAndTwoAxeDeoProductsToACart() {


        Cart cartWithTwoDoveAndTwoAxe = new Cart();

        BigDecimal expectedTotalCartPrice = new BigDecimal("314.96");
        BigDecimal expectedTotalCartTax = new BigDecimal("35.00");

        cartWithTwoDoveAndTwoAxe.addItem(soapDove, TWO_QUANTITY);
        cartWithTwoDoveAndTwoAxe.addItem(axeDeodorant, TWO_QUANTITY);

        assertThat(cartWithTwoDoveAndTwoAxe.getTotalPriceWithTax(), is(expectedTotalCartPrice));
        assertThat(cartWithTwoDoveAndTwoAxe.getTotalTaxAmount(), is(expectedTotalCartTax));
    }


    @Test
    @DisplayName("Should check total price of a cart")
    void shouldGetTotalPrice() {

        Cart cart = new Cart();

        BigDecimal expectedTotalCartPrice = new BigDecimal("224.95");

        cart.addItem(soapDove, FIVE_QUANTITY);

        assertThat(cart.getTotalPriceWithTax(), is(expectedTotalCartPrice));
    }


}
