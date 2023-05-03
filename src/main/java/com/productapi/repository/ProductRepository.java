package com.productapi.repository;

import com.productapi.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT t FROM product t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :name,'%'))")
    List<Product> findByProductLikeCaseInsensitive(@Param("name") String name);
}
