package com.example.dealapps.repository;

import com.example.dealapps.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NEJMEDDINE Ayoub
 * @created 28/07/2020 -16:53
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByLastName(@Param("name") String name);
}
