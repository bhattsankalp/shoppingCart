package com.store.management.store.customer.model;

import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {

    @Id
    private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;

}