package sales.savvy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sales.savvy.entity.Product;
import sales.savvy.repository.ProductRepository;

@Service
public class ProductServiceImplemention implements ProductService {
	
	@Autowired
	ProductRepository repo;

	@Override
	public void addProduct(Product product) { // Add Product
		repo.save(product);
		
	}

	@Override
	public List<Product> getAllProducts() { // get All Product
		return repo.findAll();
	}

	@Override
	public Product searchProduct(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void updateProduct(Product product) {
		repo.save(product);
		
	}

	@Override
	public void deleteProduct(Long id) {
		repo.deleteById(id);
	}

}
