package com.crm.modules.lead.entity;

import com.crm.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "leads")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lead {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Lead person name
    @Column(nullable = false)
    private String name;

    // Lead email
    @Column(nullable = false)
    private String email;

    // Lead Phone number
//    @Column(nullable = false)
    private String phone;

    // Lead company name
//    @Column(nullable = false)
    private String company;

    // cureent lead status
    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    // Assigned sales user
    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;
}
