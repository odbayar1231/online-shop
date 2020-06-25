package odko.nanjid.onlineshop2.repository;

import odko.nanjid.onlineshop2.domain.Buyer;
import odko.nanjid.onlineshop2.domain.Order;
import odko.nanjid.onlineshop2.domain.Seller;
import odko.nanjid.onlineshop2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

    @Query(value = "SELECT b FROM Buyer b JOIN b.following s where b.id = :buyerId AND s.id = :sellerId")
    Buyer isFollowing(Long buyerId, Long sellerId);

    @Query(value = "select b from Buyer b join b.following s where s.id = :sellerId")
    List<Buyer> getFollowersNumber(Long sellerId);

    @Query(value = "select s.orders from Seller s where s = :seller")
    List<Order> getOrdersBySeller(Seller seller);

    @Query(value = "select distinct o from Buyer b join b.orders o where b = :buyer order by o.updateTime desc ")
    List<Order> getOrdersByBuyer(Buyer buyer);


}
