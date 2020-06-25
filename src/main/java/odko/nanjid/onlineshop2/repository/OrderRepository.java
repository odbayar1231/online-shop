package odko.nanjid.onlineshop2.repository;

import odko.nanjid.onlineshop2.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
