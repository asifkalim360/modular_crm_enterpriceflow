package com.crm.modules.activity.entity;


import com.crm.modules.lead.entity.Lead;
import com.crm.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "activities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Activity title
    @Column(nullable = false)
    private String title;

    // Activity description
    @Column(length = 2000)
    private String description;

    // Activity type
    @Enumerated(EnumType.STRING)
    private ActivityType type;

    // Activity Status
    @Enumerated(EnumType.STRING)
    private ActivityStatus status;

    // Due Date/time
    private LocalDateTime dueDate;

    // Related lead
    @ManyToOne      // MANY ACTIVITIES → ONE LEAD: (One lead can have multiple follow-ups/calls/meetings).
    @JoinColumn (name = "lead_id")
    private Lead lead;

    // Assigned employee
    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assigneduser;


}
