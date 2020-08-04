package com.cvjetkovic.springecommerce.repository;

import com.cvjetkovic.springecommerce.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author Vladimir Cvjetkovic
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO categories ( description, name, parent_id) VALUES(?1,?2,?3) ", nativeQuery = true)
    void insertSubcategory(String name, String description, Long parent_id);

}