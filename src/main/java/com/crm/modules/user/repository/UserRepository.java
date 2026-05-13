package com.crm.modules.user.repository;

import com.crm.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}

// “Optional NullPointerException avoid karta hai aur explicitly batata hai ki data present bhi ho sakta hai aur absent bhi.”
