package miniproject.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import miniproject.Entity.Authority;
import miniproject.Entity.Product;
import miniproject.Services.AuthorityServive;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
@RequiredArgsConstructor
@Api(value = "Authority APIs")
public class AuthorityRestController {

	@Autowired
	AuthorityServive auService;
	
	@ApiOperation(value = "Find All Authority", response = Authority.class)
	@ApiResponses (value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorizes"),
			@ApiResponse(code = 403, message = "Forbident"),
			@ApiResponse(code = 404, message = "Not Fount")
	})
	@GetMapping()
	public List<Authority> getAll(){
		return auService.findAll();
	}
	
	
	@ApiOperation(value = "create By ID", response = Product.class)
	@PostMapping
	public Authority post(@RequestBody Authority auth) {
		return auService.create(auth);
	}
	
	@ApiOperation(value = "delete by id", response = Authority.class)
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		auService.delete(id);
	}
}
