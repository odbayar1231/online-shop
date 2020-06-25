package odko.nanjid.onlineshop2.service;

import odko.nanjid.onlineshop2.domain.Buyer;
import odko.nanjid.onlineshop2.domain.Order;
import odko.nanjid.onlineshop2.domain.Seller;
import odko.nanjid.onlineshop2.domain.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);

    public List<User> getAll();
    public User save(User user);
    public User find(Long id);
    public Seller addFollower(Long sellerId, String action);
    public boolean isFollowing(Long sellerId);
    public Buyer getAuthenticatedBuyer();
    public User getAuthenticatedUser();
    List<Order> getOrdersBySeller(Seller seller);
    List<Order> getOrdersByBuyer();
    public List<Buyer> getFollewersNumber(Long sellerId);
    Boolean buyerHasCoupon();
}
