package com.crm.modules.deal.entity;

import com.crm.modules.lead.entity.Lead;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "deals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deal {

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Deal title
    @Column(nullable = false)
    private String title;

    // Deal Amount
//    @Column(nullable = false)
    private BigDecimal amount;

    // Current Deal Stage
    @Enumerated(EnumType.STRING)
    private DealStage stage;

    // Related Lead
    @ManyToOne
    @JoinColumn(name="lead_id")
    private Lead lead;
}

// WHY BigDecimal? Interview me bahut important 🔥
//“Money values ke liye double/float use nahi karna chahiye because floating point precision issue hota hai. Financial calculations me BigDecimal preferred hota hai.”
