package com.equalexpert.shoppingcart.test;

import com.equalexpert.shoppingcart.price.Tax;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.equalexpert.shoppingcart.constant.Constants.SALES_TAX_PERCENTAGE;
import static com.equalexpert.shoppingcart.price.TaxType.SALES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TaxTest {

    @Test
    @DisplayName("Should test get percentage of tax")
    void shouldTesGetTaxPercentage() {

        Tax tax = new Tax(SALES, SALES_TAX_PERCENTAGE);
        assertThat(tax.getRate(), is(SALES_TAX_PERCENTAGE));
    }

}

