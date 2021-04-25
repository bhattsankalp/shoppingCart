package com.store.management.store.customer.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Address {
    private String line1;
    private String line2;
    private String city;
    private String country;
    private String pin;

}
