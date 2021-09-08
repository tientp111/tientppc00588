package miniproject.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import miniproject.Entity.Product;
import miniproject.Services.ProductService;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@Api(value = "Products APIs")
@RequestMapping("/rest/products")
public class ProductRestController {
	
	@Autowired
	ProductService proService;
	
	@ApiOperation(value = "Find All Products", response = Product.class)
	@ApiResponses (value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorizes"),
			@ApiResponse(code = 403, message = "Forbident"),
			@ApiResponse(code = 404, message = "Not Fount")
	})
	@GetMapping()
	public List<Product> getAll() {
		return proService.findAll();
	}
	
	@ApiOperation(value = "Find By ID", response = Product.class)
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Integer id) {
		return proService.findById(id);
	}	
	
	@ApiOperation(value = "create product", response = Product.class)
	@PostMapping
	public Product create(@RequestBody Product product) {
		return proService.create(product);
	}
	
	@ApiOperation(value = "update by id", response = Product.class)
	@PutMapping("{id}")
	public Product update(@PathVariable("id") Integer id ,@RequestBody Product product) {
		return proService.update(product);
	}
	
	@ApiOperation(value = "delete by id", response = Product.class)
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		proService.delete(id);
	}
}
