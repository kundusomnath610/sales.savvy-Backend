package sales.savvy.conrtoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sales.savvy.entity.Product;
import sales.savvy.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	//Add Product
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) { // @RequestBody Annotation Needs for Converting 
															//	Object to JSON Body. 
		service.addProduct(product);
		return "Product Add Successfully";
	}
	
	// Get All Product
	@GetMapping("/allProduct")
	public List<Product> getAllProducts(Product product) {
		return service.getAllProducts();
	}
	
	@GetMapping("/searchProduct/{id}")
	public Product searchProcuct(@PathVariable Long id) {
		return service.searchProduct(id); 
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody Product prod) {
		service.updateProduct(prod);
		return "Product Added";
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable Long id) {
		service.deleteProduct(id);
		return "Product Deleted";
		
	}
	

}
