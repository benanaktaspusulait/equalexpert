package com.equalexpert.shoppingcart.price;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 *
 *
 */
@Data
@AllArgsConstructor
@Builder
public class Price {

    private final BigDecimal value;
}
