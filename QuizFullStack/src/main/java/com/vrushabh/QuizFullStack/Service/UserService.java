package com.vrushabh.QuizFullStack.Service;

import com.vrushabh.QuizFullStack.Entity.User;
import com.vrushabh.QuizFullStack.Entity.Role;
import com.vrushabh.QuizFullStack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service; // Missing this in your snippet
import org.springframework.transaction.annotation.Transactional;

@Service // Essential for Spring to recognize this as a Bean
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void registerNewUser(User user) throws Exception {
        // 1. Logic: Check for duplicates
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("Email already exists!");
        }
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new Exception("Username already exists!");
        }

        // 2. Transformation: Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 3. Defaults: Set standard role
        user.setRole(Role.USER);

        // 4. Persistence: Save to DB
        userRepository.save(user);
    }
}