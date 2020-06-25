package odko.nanjid.onlineshop2.service;

import odko.nanjid.onlineshop2.domain.Product;
import odko.nanjid.onlineshop2.domain.Seller;

import java.util.List;


public interface ProductService {
	
	List<Product> getAll();

	List<Product> getByCategory(Integer categoryId);

	void save(Product product);

	Product find(Long id);

	void delete(Product product);

	List<Product> getProductsBySeller(Seller seller);
	
}
