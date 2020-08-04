package com.example.dealapps.repository;

import com.example.dealapps.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author NEJMEDDINE Ayoub
 * @created 04/08/2020 -10:09
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
