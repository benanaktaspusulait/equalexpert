package com.equalexpert.shoppingcart.test;

import com.equalexpert.shoppingcart.brand.Brand;
import com.equalexpert.shoppingcart.product.Product;
import com.equalexpert.shoppingcart.price.Price;
import com.equalexpert.shoppingcart.price.Tax;
import com.equalexpert.shoppingcart.util.PriceUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.equalexpert.shoppingcart.constant.Constants.DOVE_SOAP_NAME;
import static com.equalexpert.shoppingcart.constant.Constants.SALES_TAX_PERCENTAGE;
import static com.equalexpert.shoppingcart.price.TaxType.SALES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PriceTest {

    private BigDecimal salesPercentage;
    private Tax salesTax;
    private BigDecimal unitPrice;
    private Price price;

    @BeforeEach
    void setup() {
        salesPercentage = SALES_TAX_PERCENTAGE;
        salesTax = new Tax(SALES, salesPercentage);
        unitPrice = new BigDecimal("100.00");
        price = new Price(unitPrice);
    }

    @AfterEach
    void tearDown() {
        salesPercentage = null;
        salesTax = null;
        unitPrice = null;
        price = null;
    }

    @Test
    @DisplayName("Should test get price of product with tax amount")
    void shouldTestGetPriceWithTax() {

        Product product = new Product(new Brand(DOVE_SOAP_NAME), price,salesTax);
        BigDecimal expectedPrice = new BigDecimal("112.50");
        assertThat(PriceUtil.getPriceWithTax(product), is(expectedPrice));
    }
}
