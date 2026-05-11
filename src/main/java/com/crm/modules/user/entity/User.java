package com.crm.modules.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Full name of user
    @Column(nullable = false)
    private String name;

    // Email should be uniqye
    @Column(nullable = false, unique = true)
    private String email;

    // Encrypted password
    @Column(nullable = false)
    private String password;

    // Role Enum
    @Enumerated(EnumType.STRING)
    private Role role;

}
