package com.study_spring.ticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study_spring.ticketing.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    //User updateById(Long id, User user);
}
