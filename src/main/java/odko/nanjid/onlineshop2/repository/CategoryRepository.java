package odko.nanjid.onlineshop2.repository;

import odko.nanjid.onlineshop2.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
