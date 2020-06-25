package odko.nanjid.onlineshop2.service;

import odko.nanjid.onlineshop2.domain.Item;
import odko.nanjid.onlineshop2.domain.Product;
import odko.nanjid.onlineshop2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item findTopByProduct(Product product) { return itemRepository.findTopByProduct(product); }

    public void deleteItemById(Long productid) { itemRepository.deleteById(productid); }
}
