package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
        value = "SELECT * FROM product p WHERE p.price = 3500 and p.id = 1", 
        nativeQuery = true)
        List<Product> findAllProduct();
}
