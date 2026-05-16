package com.crm.modules.customer.entity;

import com.crm.modules.deal.entity.Deal;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Customer name
    @Column(nullable = false)
    private String name;

    // Customer email
    @Column(nullable = false, unique = true)
    private String email;

    // Customer phone
    private String phone;

    // Company Name
    private String company;

    // Related Deal
    @OneToOne
    @JoinColumn(name = "deal_id")
    private Deal deal;          // One Deal → One Customer

}
