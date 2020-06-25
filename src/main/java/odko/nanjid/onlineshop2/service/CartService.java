package odko.nanjid.onlineshop2.service;

import odko.nanjid.onlineshop2.domain.Item;
import odko.nanjid.onlineshop2.domain.dto.ResponseDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface CartService {
    ResponseDTO addItem(Long productId, int quantity);
    Model getCartItems(Model model);
    Model getCheckOutSummary(Model model, Long sellerId, String coupon);
    List<Item> getCartItemsBySeller(Long sellerId);
}
