package com.equalexpert.shoppingcart.product;

import com.equalexpert.shoppingcart.brand.Brand;
import com.equalexpert.shoppingcart.price.Price;
import com.equalexpert.shoppingcart.price.Tax;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class Product {

    Brand brand;
    @Getter
    Price price;
    Tax tax;

}
