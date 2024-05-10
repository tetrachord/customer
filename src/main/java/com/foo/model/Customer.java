package com.foo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String customerRef;
    private String customerName;
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String county;
    private String country;
    private String postCode;
}
