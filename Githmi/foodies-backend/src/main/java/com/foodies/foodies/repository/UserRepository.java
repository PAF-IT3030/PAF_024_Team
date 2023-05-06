package com.foodies.foodies.repository;

import com.foodies.foodies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name LIKE CONCAT('%',:name,'%')")
    List<User> findUsersWithPartOfName(@Param("name") String name);

    Boolean existsByEmail(String email);

}
