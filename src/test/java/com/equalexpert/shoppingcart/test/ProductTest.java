package com.equalexpert.shoppingcart.test;

import com.equalexpert.shoppingcart.brand.Brand;
import com.equalexpert.shoppingcart.price.Price;
import com.equalexpert.shoppingcart.price.Tax;
import com.equalexpert.shoppingcart.product.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.equalexpert.shoppingcart.constant.Constants.*;
import static com.equalexpert.shoppingcart.price.TaxType.SALES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductTest {

    private Product product;

    @BeforeEach
    void setup() {

        Tax salesTax = new Tax(SALES, SALES_TAX_PERCENTAGE);
        Price price = new Price(DOVE_PRICE);
        product = new Product(new Brand(DOVE_SOAP_NAME), price,salesTax);
    }

    @AfterEach
    void tearDown() {
        product = null;
    }


    @Test
    @DisplayName("Check getBrandName of a product")
    void shouldGetBrandName() {
        assertThat(product.getBrand().getName(), is(DOVE_SOAP_NAME));
    }

    @Test
    @DisplayName("Check getUnitPrice of a product")
    void shouldGetUnitPrice() {
        assertThat(product.getPrice().getValue(), is(DOVE_PRICE));
    }


}
