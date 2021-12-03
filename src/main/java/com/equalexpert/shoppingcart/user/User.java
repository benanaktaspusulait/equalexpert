package com.equalexpert.shoppingcart.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * User model
 */
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String firstName;
    private String secondName;
    private String userName;

}
