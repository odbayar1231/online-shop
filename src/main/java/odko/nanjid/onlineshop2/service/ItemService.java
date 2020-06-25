package odko.nanjid.onlineshop2.service;

import odko.nanjid.onlineshop2.domain.Item;
import odko.nanjid.onlineshop2.domain.Product;

public interface ItemService {

    Item findTopByProduct(Product product);

    void deleteItemById(Long productId);
}
