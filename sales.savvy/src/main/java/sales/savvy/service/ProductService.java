package sales.savvy.service;

import java.util.List;

import sales.savvy.entity.Product;

public interface ProductService {
	
	void addProduct(Product product); // Add Product Services
	
	Product searchProduct(Long id); // For Search Product
	
	List<Product> getAllProducts(); // Get All Product Service
	
	void updateProduct(Product product); // Update the Product
	
	void deleteProduct(Long id); // Delete the Product
	
	

}
