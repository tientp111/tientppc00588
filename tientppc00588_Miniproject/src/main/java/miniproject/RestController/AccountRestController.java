package miniproject.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import miniproject.Entity.Account;
import miniproject.Services.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
@Api(value = "Account APIs")
@RequiredArgsConstructor
public class AccountRestController {

	@Autowired
	AccountService acService;
	
	@ApiOperation(value = "Find All Account", response = Account.class)
	@ApiResponses (value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorizes"),
			@ApiResponse(code = 403, message = "Forbident"),
			@ApiResponse(code = 404, message = "Not Fount")
	})
	
	//Load
	@GetMapping()
	public List<Account> getAll() {
		return acService.findAll();
	}

	@GetMapping("{id}")
	public Account getOne(@PathVariable("id") String id) {
		return acService.findById(id);
	}	
	
	//Create
	@PostMapping
	public Account add(@RequestBody Account AccountData){
		return acService.add(AccountData);
	}
	
	//Update
	@PutMapping("{id}")
	public Account update(@PathVariable("id") String id ,@RequestBody Account acc) {
		return acService.update(acc);
	}
	
}
