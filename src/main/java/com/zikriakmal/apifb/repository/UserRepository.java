package com.zikriakmal.apifb.repository;

import com.zikriakmal.apifb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    User findById(Integer id);
    Optional<User> findByUsernameOrEmail(String username, String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email); // Custom query to check if email exists


}
