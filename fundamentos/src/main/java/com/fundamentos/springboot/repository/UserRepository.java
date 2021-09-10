package com.fundamentos.springboot.repository;

import com.fundamentos.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from User where u.email= ?1")
    Optional<User> findByUserEmail(String email);

}
