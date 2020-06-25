package odko.nanjid.onlineshop2.repository;

import odko.nanjid.onlineshop2.domain.Product;
import odko.nanjid.onlineshop2.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /*** List product by seller ID ***/
    List<Product> findProductsBySeller(Seller seller);

    @Query(value = "SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findProductsByCategory(Integer categoryId);
}
