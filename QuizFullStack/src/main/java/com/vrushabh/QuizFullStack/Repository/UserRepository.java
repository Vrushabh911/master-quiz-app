package com.vrushabh.QuizFullStack.Repository;



import com.vrushabh.QuizFullStack.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query methods for authentication
    Optional<User> findByEmail(String email);



    // Check if user exists for registration validation
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
