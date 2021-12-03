package com.equalexpert.shoppingcart.price;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@AllArgsConstructor
@Builder
public class Tax {

    TaxType type;
    BigDecimal rate;

}
