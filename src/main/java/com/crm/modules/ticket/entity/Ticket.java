package com.crm.modules.ticket.entity;

import com.crm.modules.customer.entity.Customer;
import com.crm.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    // Primary Key.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ticket title.
    @Column(nullable = false)
    private String title;

    // Detailed Issue Description.
    @Column(length = 2000)
    private String description;

    // Ticket Status
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    // Ticket Priority
    @Enumerated(EnumType.STRING)
    private TicketPriority priority;

    // Related customer
    @ManyToOne          // MANY TICKETS → ONE CUSTOMER : (One customer can create multiple tickets)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Assigned Support User
    @ManyToOne      // MANY TICKETS → ONE SUPPORT USER : (Many tickets can be assigned to one support employee)
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

}
