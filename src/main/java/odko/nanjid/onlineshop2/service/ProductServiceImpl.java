package odko.nanjid.onlineshop2.service;

import odko.nanjid.onlineshop2.domain.Product;
import odko.nanjid.onlineshop2.domain.Seller;
import odko.nanjid.onlineshop2.exception.ProductNotFoundException;
import odko.nanjid.onlineshop2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public List<Product> getByCategory(Integer categoryId) {
		return productRepository.findProductsByCategory(categoryId);
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public Product find(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id.toString()));
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public List<Product> getProductsBySeller(Seller seller) {
		return productRepository.findProductsBySeller(seller);
	}

}
