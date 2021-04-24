package com.Alish.midka.repository;

import com.Alish.midka.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM Product n WHERE n.id=?1", nativeQuery = true)
    Product findByIds(Long id);

}
