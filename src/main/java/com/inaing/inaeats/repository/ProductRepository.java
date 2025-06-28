package com.inaing.inaeats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inaing.inaeats.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = """
                SELECT id, ts_rank_cd(product_search_vector, to_tsquery('english', :query)) AS rank
                FROM product
                WHERE product_search_vector @@ to_tsquery('english', :query)
                ORDER BY rank DESC
                LIMIT 10
            """, nativeQuery = true)
    List<String> searchProducts(@Param("query") String query);
}
