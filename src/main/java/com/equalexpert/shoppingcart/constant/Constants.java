package com.equalexpert.shoppingcart.constant;

import java.math.BigDecimal;

public class Constants {

    // brand names
    public final static String DOVE_SOAP_NAME = "Dove";
    public final static String AXE_DEO_NAME = "Axe Deo";

    // product prices
    public final static BigDecimal DOVE_PRICE = new BigDecimal("39.99");
    public final static BigDecimal AXE_PRICE = new BigDecimal("99.99");

    // tax percentages
    public final static BigDecimal SALES_TAX_PERCENTAGE = new BigDecimal("12.5");

    // rounding
    public static final Integer PRECISION = 2;
    public static final BigDecimal HUNDRED = new BigDecimal("100");

    // quantities
    public static final Integer EIGHT_QUANTITY = 8;
    public static final Integer FIVE_QUANTITY = 5;
    public static final Integer THREE_QUANTITY = 3;
    public static final Integer TWO_QUANTITY = 2;

}
